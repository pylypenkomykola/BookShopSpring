package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.mapper.converter.Convert;
import pl.edu.pwsztar.domain.repository.BookRepository;
import pl.edu.pwsztar.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final Convert<List<Book>, List<BookDto>> bookListMapper;
    private final Convert<Book, BookDto> bookMapper;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           Convert<List<Book>, List<BookDto>> bookListMapper,
                           Convert<Book, BookDto> bookMapper) {
        this.bookRepository = bookRepository;
        this.bookListMapper = bookListMapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getBooks() {
        return bookListMapper.convert(bookRepository.findAll());
    }

    @Override
    public BookDto getBook(Long bookId) {
        return bookMapper.convert(bookRepository.findById(bookId).orElse(null));
    }
}
