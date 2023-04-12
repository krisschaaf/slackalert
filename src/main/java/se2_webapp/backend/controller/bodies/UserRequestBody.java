package se2_webapp.backend.controller.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestBody {
    private String username;
    private String email;
    private String password;
}