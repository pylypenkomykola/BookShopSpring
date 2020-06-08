package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.dto.book.CreateBookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks();
    BookDto getBook(Long bookId);
    void createBook(CreateBookDto createBookDto) ;
    void deleteBook(Long bookId);
}
