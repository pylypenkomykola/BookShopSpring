package pl.edu.pwsztar.domain.mapper.client;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.client.ClientDto;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class ClientDtoMapper implements Convert<ClientDto, Client> {
    @Override
    public Client convert(ClientDto from) {
        return new Client.Builder()
                .email(from.getEmail())
                .username(from.getUsername())
                .password(from.getPassword())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .address(from.getAddress())
                .phoneNumber(from.getPhoneNumber())
                .build();
    }
}
