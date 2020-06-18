package pl.edu.pwsztar.domain.dto.client;

import pl.edu.pwsztar.domain.enums.UserInfo;

import java.io.Serializable;

public class ClientModifyDto implements Serializable {
    private String data;
    private UserInfo userInfo;

    public ClientModifyDto() {
    }

    private ClientModifyDto(Builder builder) {
        this.data = builder.data;
        this.userInfo = builder.userInfo;
    }

    public String getData() {
        return data;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public static final class Builder {
        private String data;
        private UserInfo userInfo;

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Builder userInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
            return this;
        }

        public ClientModifyDto build() {
            return new ClientModifyDto(this);
        }
    }
}
