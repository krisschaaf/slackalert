package se2_webapp.backend.webClients.bodies.gitlabBodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String name;

    @Override
    public String toString() {
        return
                "User '" + getUsername() + "' " +
                        "has id '" + getId() + "' " +
                "with name '" + getName() + "'";
    }
}
