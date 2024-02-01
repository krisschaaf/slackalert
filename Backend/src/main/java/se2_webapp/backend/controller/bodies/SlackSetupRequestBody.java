package se2_webapp.backend.controller.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlackSetupRequestBody {
    private Long userId;
    private String email;
    private String channelName;
    private String baseUrl;
    private String token;
}