package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.dto.client.ClientBookDto;

import java.util.List;

public interface ShoppingCartService {
    List<BookDto> getClientBooks(Long userId);
    void addNewBook(ClientBookDto clientBookDto);
    void removeClientBook(ClientBookDto clientBookDto);
    void clearClientCart(Long userId);
}
