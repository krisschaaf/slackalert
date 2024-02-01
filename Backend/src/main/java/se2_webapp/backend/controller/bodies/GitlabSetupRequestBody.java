package se2_webapp.backend.controller.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitlabSetupRequestBody {
    private Long userId;
    private String email;
    private String projectName;
    private int projectID;
    private String baseURL;
    private String token;
}