package pl.edu.pwsztar.domain.mapper.book;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class BookDtoMapper implements Convert<BookDto, Book> {
    @Override
    public Book convert(BookDto from) {
        return new Book.Builder()
                .bookId(from.getBookId())
                .picture(from.getPicture())
                .title(from.getTitle())
                .description(from.getDescription())
                .type(from.getType())
                .price(from.getPrice())
                .number(from.getNumber())
                .build();
    }
}
