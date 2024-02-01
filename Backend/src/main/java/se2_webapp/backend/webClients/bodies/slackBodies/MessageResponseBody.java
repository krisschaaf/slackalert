package se2_webapp.backend.webClients.bodies.slackBodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class MessageResponseBody {
    private String ok;
    private String error;
    private String warning;
}
