package pl.edu.pwsztar.service;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pwsztar.domain.dto.client.ClientDto;
import pl.edu.pwsztar.domain.dto.client.ClientModifyDto;

public interface ClientService {
    ClientDto getClientInfo(Long userId);
    boolean modifyClientEmail(Long userId, String email);
    boolean modifyClientUsername(Long userId, String username);
    boolean modifyClientPassword(Long userId, String password);
    boolean modifyClientFirstName(Long userId, String firstName);
    boolean modifyClientLastName(Long userId, String lastName);
    boolean modifyClientAddress(Long userId, String address);
    boolean modifyClientPhone(Long userId, String phoneNumber);
    boolean completeModify(Long userId, ClientModifyDto clientModifyDto);
}
