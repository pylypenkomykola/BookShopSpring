package pl.edu.pwsztar.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="books", schema = "book_shop")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Float price;

    @Column(name = "number")
    private Integer number;

    public Book() {
    }

    private Book(Builder builder) {
        this.bookId = builder.bookId;
        this.picture = builder.picture;
        this.title = builder.title;
        this.description = builder.description;
        this.type = builder.type;
        this.price = builder.price;
        this.number = builder.number;
    }

    @OneToMany(mappedBy = "book")
    private List<Order> orders;

    @OneToMany(mappedBy = "book")
    private List<ShoppingCart> cart;

    public Long getBookId() {
        return bookId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getNumber() {
        return number;
    }

    public static final class Builder{
        private Long bookId;
        private byte[] picture;
        private String title;
        private String description;
        private String type;
        private Float price;
        private Integer number;

        public Builder bookId(Long bookId){
            this.bookId = bookId;
            return this;
        }

        public Builder picture(byte[] picture){
            this.picture = picture;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder price(Float price){
            this.price = price;
            return this;
        }

        public Builder number(Integer number){
            this.number = number;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }
}
