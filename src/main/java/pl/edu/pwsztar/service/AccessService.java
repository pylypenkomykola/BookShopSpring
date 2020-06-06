package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.AuthenticationDto;
import pl.edu.pwsztar.domain.dto.AuthenticationResult;
import pl.edu.pwsztar.domain.dto.ClientDto;

public interface AccessService {
    AuthenticationResult authentication(AuthenticationDto user);
    boolean register(ClientDto client);
    void removeHashSession(Long userId);
}
