package pl.edu.pwsztar.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/order")
public class OrderApiController {

    @CrossOrigin
    @PostMapping(value = "/complete-order/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> addBookToCart(@PathVariable Long userId){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
