package pl.edu.pwsztar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.service.OrderService;

@Controller
@RequestMapping(value = "/api/order")
public class OrderApiController {
    private final OrderService orderService;

    @Autowired
    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @CrossOrigin
    @PostMapping(value = "/{userId}/complete-order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> completeOrder(@PathVariable Long userId){

        this.orderService.completeClientOrder(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
