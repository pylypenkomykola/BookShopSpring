package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.dto.book.BookInfoDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.entity.Order;
import pl.edu.pwsztar.domain.entity.key.OrderKey;
import pl.edu.pwsztar.domain.mapper.converter.Convert;
import pl.edu.pwsztar.domain.repository.ClientRepository;
import pl.edu.pwsztar.domain.repository.OrderRepository;
import pl.edu.pwsztar.domain.repository.ShoppingCartRepository;
import pl.edu.pwsztar.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;


    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    @Autowired
    public OrderServiceImpl(ShoppingCartRepository shoppingCartRepository,
                            OrderRepository orderRepository,
                            ClientRepository clientRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;

    }

    @Override
    public void completeClientOrder(Long userId){
        Optional<List<BookInfoDto>> checkClientBooks = Optional.ofNullable(shoppingCartRepository.findClientBooksInfo(userId));

        if(checkClientBooks.isPresent()){
            Client client = clientRepository.findClient(userId);
            List<BookInfoDto> clientBooks = checkClientBooks.get();
            clientBooks.stream().map(book -> {
                orderRepository.save(
                        new Order.Builder()
                .key(new OrderKey(userId, book.getBook().getBookId(), dataFormat.format(new Date())))
                .client(client)
                .book(book.getBook())
                .date(dataFormat.format(new Date()))
                .price(book.getBook().getPrice()*book.getBookNumber())
                .build());
                return null;
            });
        }
    }
}
