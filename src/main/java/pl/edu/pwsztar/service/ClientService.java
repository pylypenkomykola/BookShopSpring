package pl.edu.pwsztar.service;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pwsztar.domain.dto.client.ClientDto;

public interface ClientService {
    ClientDto getClientInfo(Long userId);
    boolean modifyClientEmail(Long userId, String email);
    boolean modifyClientUsername(Long userId, String username);
    boolean modifyClientPassword(Long userId, String password);
    void modifyClientFirstName(Long userId, String firstName);
    void modifyClientLastName(Long userId, String lastName);
    void modifyClientAddress(Long userId, String address);
    void modifyClientPhone(Long userId, String phoneNumber);
}
