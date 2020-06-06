package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.auth.AuthenticationDto;
import pl.edu.pwsztar.domain.dto.auth.AuthenticationResult;
import pl.edu.pwsztar.domain.dto.client.ClientDto;

public interface AccessService {
    AuthenticationResult authentication(AuthenticationDto user);
    boolean register(ClientDto client);
    void removeHashSession(Long userId);
}
