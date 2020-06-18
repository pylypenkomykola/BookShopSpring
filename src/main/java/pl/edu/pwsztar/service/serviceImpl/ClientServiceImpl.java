package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.client.ClientDto;
import pl.edu.pwsztar.domain.dto.client.ClientModifyDto;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.mapper.client.ClientMapper;
import pl.edu.pwsztar.domain.repository.ClientRepository;
import pl.edu.pwsztar.service.ClientService;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository,
                             ClientMapper clientMapper) {
        this.clientRepository = clientRepository;

        this.clientMapper = clientMapper;
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    @Override
    public ClientDto getClientInfo(Long userId) {
        return clientMapper.convert(clientRepository.findClient(userId));
    }

    @Override
    public boolean modifyClientEmail(Long userId, String email) {
        Optional<ClientDto> checkEmail = Optional.ofNullable(clientMapper.convert(clientRepository.findClientByEmailOrUsername(email)));

        if(checkEmail.isEmpty()){
            clientRepository.changeClientEmail(userId, email);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyClientUsername(Long userId, String username) {
        Optional<ClientDto> checkEmail = Optional.ofNullable(clientMapper.convert(clientRepository.findClientByEmailOrUsername(username)));

        if(checkEmail.isEmpty()){
            clientRepository.changeClientUsername(userId, username);
            return true;
        }

        return false;
    }

    @Override
    public boolean modifyClientPassword(Long userId, String password) {
        ClientDto client = clientMapper.convert(clientRepository.findClient(userId));
        try {
            String encryptedPassword = toHexString(getSHA(password));

            if(encryptedPassword.equals(client.getPassword())) {
                return false;
            }

            clientRepository.changeClientPassword(userId, encryptedPassword);
            return true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modifyClientFirstName(Long userId, String firstName) {
        clientRepository.changeClientFirstName(userId, firstName);
        return true;
    }

    @Override
    public boolean modifyClientLastName(Long userId, String lastName) {
        clientRepository.changeClientLastName(userId, lastName);
        return true;
    }

    @Override
    public boolean modifyClientAddress(Long userId, String address) {
        clientRepository.changeClientAddress(userId, address);
        return true;
    }

    @Override
    public boolean modifyClientPhone(Long userId, String phoneNumber) {
        clientRepository.changeClientPhone(userId, phoneNumber);
        return true;
    }

    @Override
    public boolean completeModify(Long userId, ClientModifyDto clientModifyDto) {
        switch (clientModifyDto.getUserInfo()) {
            case USERNAME:
                return modifyClientUsername(userId, clientModifyDto.getData());
            case EMAIL:
                return modifyClientEmail(userId, clientModifyDto.getData());
            case PASSWORD:
                return modifyClientPassword(userId, clientModifyDto.getData());
            case FIRSTNAME:
                return modifyClientFirstName(userId, clientModifyDto.getData());
            case LASTNAME:
                return modifyClientLastName(userId, clientModifyDto.getData());
            case ADDRESS:
                return modifyClientAddress(userId, clientModifyDto.getData());
            case PHONENUMBER:
                return modifyClientPhone(userId, clientModifyDto.getData());
            default:
                return false;
        }
    }
}
