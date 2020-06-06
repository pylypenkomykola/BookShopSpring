package pl.edu.pwsztar.domain.mapper.book;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookListMapper implements Convert<List<Book>, List<BookDto>> {
    @Override
    public List<BookDto> convert(List<Book> from) {
        return from.stream().map(book -> {
            return new BookDto.Builder()
                    .bookId(book.getBookId())
                    .picture(book.getPicture())
                    .title(book.getTitle())
                    .description(book.getDescription())
                    .type(book.getType())
                    .price(book.getPrice())
                    .number(book.getNumber())
                    .build();
        })
                .collect(Collectors.toList());
    }
}
