package se2_webapp.backend.controller.bodies;

import lombok.Getter;
import lombok.Setter;
import se2_webapp.backend.persistance.model.AlertingSetup;
import se2_webapp.backend.persistance.model.GitlabSetup;
import se2_webapp.backend.persistance.model.SlackSetup;

@Getter
@Setter
public class ConfigResponseBody {
    private Long userId;
    private String gitlabEmail;
    private String gitlabProjectName;
    private int gitlabProjectID;
    private String gitlabBaseURL;
    private String gitlabToken;
    private String slackEmail;
    private String slackChannelName;
    private String slackBaseUrl;
    private String slackToken;
    private boolean alertingCheckbox1;
    private boolean alertingCheckbox2;
    private boolean alertingCheckbox3;
    private boolean alertingCheckbox4;

    public ConfigResponseBody(GitlabSetup gitlabSetup, SlackSetup slackSetup, AlertingSetup alertingSetup) {
        this.userId = gitlabSetup.getUserId();
        
        this.gitlabEmail = gitlabSetup.getEmail();
        this.gitlabProjectName = gitlabSetup.getProjectName();
        this.gitlabProjectID = gitlabSetup.getProjectID();
        this.gitlabBaseURL = gitlabSetup.getBaseURL();
        this.gitlabToken = gitlabSetup.getToken();

        this.slackEmail = slackSetup.getEmail();
        this.slackChannelName = slackSetup.getChannelName();
        this.slackBaseUrl = slackSetup.getBaseUrl();
        this.slackToken = slackSetup.getToken();

        this.alertingCheckbox1 = alertingSetup.isPostIssues();
        this.alertingCheckbox2 = alertingSetup.isPostUpdatedIssues();
        this.alertingCheckbox3 = alertingSetup.isPostPipelines();
        this.alertingCheckbox4 = alertingSetup.isPostVariables();
    }
}