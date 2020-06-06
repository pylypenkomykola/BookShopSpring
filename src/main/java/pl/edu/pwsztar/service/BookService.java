package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.book.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks();
    BookDto getBook(Long bookId);
}
