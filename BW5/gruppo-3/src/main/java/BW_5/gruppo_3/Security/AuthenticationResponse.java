package BW_5.gruppo_3.Security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import BW_5.gruppo_3.entity.User;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String token;

    @JsonIgnoreProperties(value = "password")
    private User user;

    public AuthenticationResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
