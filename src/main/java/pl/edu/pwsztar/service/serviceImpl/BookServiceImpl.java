package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.dto.book.CreateBookDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.mapper.converter.Convert;
import pl.edu.pwsztar.domain.repository.BookRepository;
import pl.edu.pwsztar.service.BookService;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
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

    public static byte[] recoverImageFromUrl(String urlText) throws Exception {
        URL url = new URL(urlText);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte [] buffer = new byte[ 1024 ];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }

        return output.toByteArray();
    }

    @Override
    public void createBook(CreateBookDto createBookDto) {
        byte[] picture = null;
        try {
            picture = recoverImageFromUrl(createBookDto.getPicture());
        } catch (Exception e) {
            e.printStackTrace();
        }

        bookRepository.save(new Book.Builder()
                .description(createBookDto.getDescription())
                .picture(picture)
                .title(createBookDto.getTitle())
                .type(createBookDto.getType())
                .price(createBookDto.getPrice())
                .number(createBookDto.getNumber())
                .build());
    }

    @Override
    public List<BookDto> getBooks() {
        return bookListMapper.convert(bookRepository.findAll());
    }

    @Override
    public BookDto getBook(Long bookId) {
        return bookMapper.convert(bookRepository.findById(bookId).orElse(null));
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
