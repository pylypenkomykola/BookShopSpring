package pl.edu.pwsztar.domain.mapper.book;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class BookMapper implements Convert<Book, BookDto> {
    @Override
    public BookDto convert(Book from) {
        return new BookDto.Builder()
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
