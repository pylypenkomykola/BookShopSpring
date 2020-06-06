package pl.pwsztar.edu.service;

import pl.pwsztar.edu.domain.dto.AuthenticationDto;
import pl.pwsztar.edu.domain.dto.AuthenticationResult;
import pl.pwsztar.edu.domain.dto.ClientDto;

public interface AccessService {
    AuthenticationResult authentication(AuthenticationDto user);
    boolean register(ClientDto client);
    void removeHashSession(Long userId);
}
