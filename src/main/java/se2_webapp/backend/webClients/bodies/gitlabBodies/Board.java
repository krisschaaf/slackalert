package se2_webapp.backend.webClients.bodies.gitlabBodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Board {
    private int id;
    private String name;
    private List[] lists;
}
