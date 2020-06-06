package pl.pwsztar.edu.domain.dto;

import java.io.Serializable;

public class BookDto implements Serializable {
    private Long bookId;
    private byte[] picture;
    private String title;
    private String description;
    private String type;
    private Float price;
    private Integer number;

    public BookDto() {
    }

    private BookDto(Builder builder) {
        this.bookId = builder.bookId;
        this.picture = builder.picture;
        this.title = builder.title;
        this.description = builder.description;
        this.type = builder.type;
        this.price = builder.price;
        this.number = builder.number;
    }

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

        public BookDto build(){
            return new BookDto(this);
        }
    }
}
