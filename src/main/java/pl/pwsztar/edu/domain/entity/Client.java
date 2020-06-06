package pl.pwsztar.edu.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients", schema = "book_shop")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Client() {
    }

    private Client(Builder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    @OneToMany(mappedBy = "client")
    private List<ShoppingCart> carts;

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }




    public static final class Builder{
        private Long userId;
        private String email;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String address;
        private String phoneNumber;

        public Builder() {
        }

        public Builder(Client copy) {
            this.userId = copy.getUserId();
            this.email = copy.getEmail();
            this.username = copy.getUsername();
            this.password = copy.getPassword();
            this.firstName = copy.getFirstName();
            this.lastName = copy.getLastName();
            this.address = copy.getAddress();
            this.phoneNumber = copy.getPhoneNumber();
        }

        public Builder userId(Long userId){
            this.userId = userId;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Client build(){
            return new Client(this);
        }
    }
}
