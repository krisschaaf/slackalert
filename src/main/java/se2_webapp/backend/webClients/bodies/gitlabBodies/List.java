package se2_webapp.backend.webClients.bodies.gitlabBodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    private int id;
    private Label label;
    private int position;
}
