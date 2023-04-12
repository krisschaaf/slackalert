package se2_webapp.backend.webClients.bodies.slackBodies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageRequestBody implements Body {
    private String Channel;
    private String text;
}
