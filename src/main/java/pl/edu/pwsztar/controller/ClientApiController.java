package pl.edu.pwsztar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.domain.dto.client.ClientDto;
import pl.edu.pwsztar.domain.dto.client.ClientModifyDto;
import pl.edu.pwsztar.service.ClientService;

@Controller
@RequestMapping(value = "/api/user")
public class ClientApiController {
    private final ClientService clientService;

    @Autowired
    public ClientApiController(ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ClientDto> getInfo(@PathVariable Long userId) {
        ClientDto result = null;

        result = clientService.getClientInfo(userId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/edit/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> modifyData(@PathVariable Long userId, @RequestBody ClientModifyDto clientModifyDto) {
        boolean result = false;

        result = clientService.completeModify(userId, clientModifyDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
