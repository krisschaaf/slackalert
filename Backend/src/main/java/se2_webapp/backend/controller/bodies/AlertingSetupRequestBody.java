package se2_webapp.backend.controller.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertingSetupRequestBody {
    private Long userId;
    private boolean postIssues;
    private boolean postUpdatedIssues;
    private boolean postPipelines;
    private boolean postVariables;
}