package se2_webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se2_webapp.backend.persistance.model.AlertingSetup;
import se2_webapp.backend.persistance.model.User;
import se2_webapp.backend.webClients.GitlabClient;
import se2_webapp.backend.webClients.SlackClient;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Issue;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Pipeline;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Variable;

@Service
public class AlertingService {

    @Autowired
    AlertingSetupService alertingSetupService;

    @Autowired
    UserService userService;

    @Autowired
    SlackClient slackClient;

    @Autowired
    GitlabClient gitlabClient;

    public void postAlert(Long id) {
        String username = this.getUsername(id);
        slackClient.sendMessage("Received alert from '" + username + "'!").block();

        AlertingSetup alertingSetup = alertingSetupService.findAlertingSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "AlertingSetup not found"));

        if(alertingSetup.isPostIssues()) this.postIssues();
        if(alertingSetup.isPostUpdatedIssues()) this.postUpdatedIssues();
        if(alertingSetup.isPostPipelines()) this.postPipelines();
        if(alertingSetup.isPostVariables()) this.postVariables();
    }

    public String getUsername(Long id) {
        User user = this.userService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        return user.getUsername();
    }

    public void postIssues() {
        String response = "Issues: \r\n\r\n";
        for (Issue issue: gitlabClient.getIssues()) {
            response += issue.toString();
        }
        response += "\r\n\r\n";
        slackClient.sendMessage(response).block();
    }

    public void postUpdatedIssues() {
        String response = "Updated issues: \r\n\r\n";
        for (Issue issue: gitlabClient.getUpdatedIssues()) {
            response += issue.toString();
        }
        response += "\r\n\r\n";
        slackClient.sendMessage(response).block();
    }

    public void postPipelines() {
        String response = "Pipelines: \r\n\r\n";
        for (Pipeline pipeline: gitlabClient.getPipelines()) {
            response += pipeline.toString();
        }
        response += "\r\n\r\n";
        slackClient.sendMessage(response).block();
    }

    public void postVariables() {
        String response = "Variables: \r\n\r\n";
        for (Variable variable: gitlabClient.getVariables()) {
            response += variable.toString();
        }
        response += "\r\n\r\n";
        slackClient.sendMessage(response).block();
    }
}
