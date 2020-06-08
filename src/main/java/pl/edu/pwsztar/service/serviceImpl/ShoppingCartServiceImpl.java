package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.dto.client.ClientBookDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.entity.ShoppingCart;
import pl.edu.pwsztar.domain.entity.key.ShoppingCartKey;
import pl.edu.pwsztar.domain.mapper.converter.Convert;
import pl.edu.pwsztar.domain.repository.BookRepository;
import pl.edu.pwsztar.domain.repository.ClientRepository;
import pl.edu.pwsztar.domain.repository.ShoppingCartRepository;
import pl.edu.pwsztar.service.ShoppingCartService;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    private final Convert<List<Book>, List<BookDto>> bookListMapper;


    @Autowired
    public ShoppingCartServiceImpl(ClientRepository clientRepository,
                                   BookRepository bookRepository,
                                   ShoppingCartRepository shoppingCartRepository,
                                   Convert<List<Book>, List<BookDto>> bookListMapper) {
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookListMapper = bookListMapper;
    }

    @Override
    public List<BookDto> getClientBooks(Long userId) {
        return bookListMapper.convert(shoppingCartRepository.findClientBooks(userId));
    }

    @Override
    public void addNewBook(ClientBookDto clientBookDto) {
        Optional<Client> checkClient = clientRepository.findById(clientBookDto.getUserId());
        Optional<Book> checkBook = bookRepository.findById(clientBookDto.getBookId());

        if(checkClient.isPresent() && checkBook.isPresent()){
            shoppingCartRepository.save(
                    new ShoppingCart.Builder()
            .key(new ShoppingCartKey(clientBookDto.getUserId(),clientBookDto.getBookId()))
            .client(checkClient.get())
            .book(checkBook.get())
            .booksNumber(clientBookDto.getBooksNumber())
            .build());
        }
    }

    @Override
    public void removeClientBook(ClientBookDto clientBookDto) {
        shoppingCartRepository.deleteBookById(clientBookDto.getUserId(), clientBookDto.getBookId());
    }

    @Override
    public void clearClientCart(Long userId) {
        shoppingCartRepository.clearClientCartById(userId);
    }
}
