package pl.edu.pwsztar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.dto.client.ClientBookDto;
import pl.edu.pwsztar.service.ShoppingCartService;

import java.util.List;

@Controller
@RequestMapping(value = "/api/cart")
public class ShoppingCartApiController {
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartApiController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @CrossOrigin
    @GetMapping(value = "/cart-books/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BookDto>> getCartBooks(@PathVariable Long userId){
        List<BookDto> result = null;

        result = shoppingCartService.getClientBooks(userId);

        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> addBookToCart(@RequestBody ClientBookDto clientBookDto){

        shoppingCartService.addNewBook(clientBookDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> removeBookFromCart(@RequestBody ClientBookDto clientBookDto){

        shoppingCartService.removeClientBook(clientBookDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/clear/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> clearCart(@PathVariable Long userId){

        shoppingCartService.clearClientCart(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
