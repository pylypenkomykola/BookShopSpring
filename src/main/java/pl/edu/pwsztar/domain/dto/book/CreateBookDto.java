package pl.edu.pwsztar.domain.dto.book;

import java.io.Serializable;

public class CreateBookDto implements Serializable {
    private String picture;
    private String title;
    private String description;
    private String type;
    private Float price;
    private Integer number;

    public CreateBookDto() {
    }

    private CreateBookDto(Builder builder) {
        this.picture = builder.picture;
        this.title = builder.title;
        this.description = builder.description;
        this.type = builder.type;
        this.price = builder.price;
        this.number = builder.number;
    }


    public String getPicture() {
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
        private String picture;
        private String title;
        private String description;
        private String type;
        private Float price;
        private Integer number;


        public Builder picture(String picture){
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

        public CreateBookDto build(){
            return new CreateBookDto(this);
        }
    }
}
