package pl.edu.pwsztar.domain.entity;

import pl.edu.pwsztar.domain.entity.key.OrderKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders", schema = "book_shop")
public class Order implements Serializable {

    @EmbeddedId
    private OrderKey key;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private Client client;

    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private Float price;

    public Order() {
    }

    private Order(Builder builder) {
        this.key = builder.key;
        this.client = builder.client;
        this.book = builder.book;
        this.date = builder.date;
        this.price = builder.price;
    }

    public OrderKey getKey() {
        return key;
    }

    public Client getClient() {
        return client;
    }

    public Book getBook() {
        return book;
    }

    public String getDate() {
        return date;
    }

    public Float getPrice() {
        return price;
    }

    public static final class Builder{
        private OrderKey key;
        private Client client;
        private Book book;
        private String date;
        private Float price;

        public Builder key(OrderKey key){
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

        public Builder date(String date){
            this.date = date;
            return this;
        }

        public Builder price(Float price){
            this.price = price;
            return this;
        }


        public Order build(){
            return new Order(this);
        }
    }
}
