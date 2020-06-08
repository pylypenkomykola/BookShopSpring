package pl.edu.pwsztar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.domain.dto.book.BookInfoDto;
import pl.edu.pwsztar.domain.entity.Book;
import pl.edu.pwsztar.domain.entity.ShoppingCart;
import pl.edu.pwsztar.domain.entity.key.ShoppingCartKey;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartKey>, CrudRepository<ShoppingCart, ShoppingCartKey> {
    @Query("SELECT cart.book FROM ShoppingCart cart WHERE cart.client.userId = ?1")
    List<Book> findClientBooks(Long userId);

    @Query("SELECT cart.book, cart.booksNumber FROM ShoppingCart cart WHERE cart.client.userId = ?1")
    List<BookInfoDto> findClientBooksInfo(Long userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ShoppingCart cart WHERE cart.client.userId = ?1 AND cart.book.bookId = ?2")
    void deleteBookById(Long userId, Long bookId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ShoppingCart cart WHERE cart.client.userId = ?1")
    void clearClientCartById(Long userId);
}
