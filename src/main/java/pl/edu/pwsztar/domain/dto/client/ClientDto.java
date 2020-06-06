package pl.edu.pwsztar.domain.dto.client;



import java.io.Serializable;

public class ClientDto implements Serializable {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public ClientDto() {
    }

    private ClientDto(Builder builder) {
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
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
        private String email;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String address;
        private String phoneNumber;

        public Builder() {
        }

        public Builder(ClientDto copy) {
            this.email = copy.getEmail();
            this.username = copy.getUsername();
            this.password = copy.getPassword();
            this.firstName = copy.getFirstName();
            this.lastName = copy.getLastName();
            this.address = copy.getAddress();
            this.phoneNumber = copy.getPhoneNumber();
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

        public ClientDto build(){
            return new ClientDto(this);
        }
    }
}
