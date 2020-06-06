package pl.edu.pwsztar.domain.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderKey implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    private String orderDay;

    public OrderKey() {
    }

    public OrderKey(Long userId, Long bookId, String orderDay) {
        this.userId = userId;
        this.bookId = bookId;
        this.orderDay = orderDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderKey orderKey = (OrderKey) o;
        return Objects.equals(userId, orderKey.userId) &&
                Objects.equals(bookId, orderKey.bookId) &&
                Objects.equals(orderDay, orderKey.orderDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId, orderDay);
    }
}
