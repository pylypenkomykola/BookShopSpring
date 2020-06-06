package pl.pwsztar.edu.domain.entity;

import pl.pwsztar.edu.domain.entity.key.ShoppingCartKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shopping_cart", schema = "book_shop")
public class ShoppingCart implements Serializable {
    @EmbeddedId
    private ShoppingCartKey key;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private Client client;

    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "booksNumber")
    private Integer booksNumber;

    public ShoppingCart() {
    }

    private ShoppingCart(Builder builder) {
        this.key = builder.key;
        this.client = builder.client;
        this.book = builder.book;
        this.booksNumber = builder.booksNumber;
    }

    public ShoppingCartKey getKey() {
        return key;
    }

    public Client getClient() {
        return client;
    }

    public Book getBook() {
        return book;
    }

    public Integer getBooksNumber() {
        return booksNumber;
    }

    public static final class Builder {
        private ShoppingCartKey key;
        private Client client;
        private Book book;
        private Integer booksNumber;

        public Builder key(ShoppingCartKey key){
            this.key = key;
            return this;
        }

        public Builder client(Client client){
            this.client = client;
            return this;
        }

        public Builder book(Book book){
            this.book = book;
            return this;
        }

        public Builder booksNumber(Integer booksNumber){
            this.booksNumber = booksNumber;
            return this;
        }

        public ShoppingCart build(){
            return new ShoppingCart(this);
        }
    }
}
