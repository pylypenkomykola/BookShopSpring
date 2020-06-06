package pl.pwsztar.edu.domain.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ShoppingCartKey implements Serializable{
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long book_id;

    public ShoppingCartKey() {
    }

    public ShoppingCartKey(Long userId, Long book_id) {
        this.userId = userId;
        this.book_id = book_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartKey that = (ShoppingCartKey) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(book_id, that.book_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, book_id);
    }
}
