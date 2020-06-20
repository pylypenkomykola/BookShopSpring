package pl.edu.pwsztar.domain.dto.book;

import pl.edu.pwsztar.domain.entity.Book;

import java.io.Serializable;

public class BookInfoDto implements Serializable {
    private Integer bookNumber;
    private Book book;

    public BookInfoDto() {
    }

    public BookInfoDto(Integer bookNumber, Book book) {
        this.bookNumber = bookNumber;
        this.book = book;
    }

    private BookInfoDto(Builder builder) {
        this.bookNumber = builder.bookNumber;
        this.book = builder.book;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public Book getBook() {
        return book;
    }

    public static final class Builder{
        private Integer bookNumber;
        private Book book;

        public Builder bookNumber(Integer bookNumber){
            this.bookNumber = bookNumber;
            return this;
        }

        public Builder book(Book book){
            this.book = book;
            return this;
        }

        public BookInfoDto build(){
            return new BookInfoDto(this);
        }
    }
}
