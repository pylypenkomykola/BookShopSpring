package pl.edu.pwsztar.domain.dto.client;

import java.io.Serializable;

public class ClientBookDto implements Serializable {
    private Long userId;
    private Long bookId;
    private Integer booksNumber;

    public ClientBookDto() {
    }

    private ClientBookDto(Builder builder) {
        this.userId = builder.userId;
        this.bookId = builder.bookId;
        this.booksNumber = builder.booksNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Integer getBooksNumber() {
        return booksNumber;
    }

    public static final class Builder{
        private Long userId;
        private Long bookId;
        private Integer booksNumber;

        public Builder userId(Long userId){
            this.userId = userId;
            return this;
        }

        public Builder bookId(Long bookId){
            this.bookId = bookId;
            return this;
        }

        public Builder booksNumber(Integer booksNumber){
            this.booksNumber = booksNumber;
            return this;
        }

        public ClientBookDto build(){
            return new ClientBookDto(this);
        }
    }
}
