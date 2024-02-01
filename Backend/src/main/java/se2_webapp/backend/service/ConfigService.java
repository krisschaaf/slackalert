package se2_webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se2_webapp.backend.controller.bodies.ConfigResponseBody;
import se2_webapp.backend.persistance.model.AlertingSetup;
import se2_webapp.backend.persistance.model.GitlabSetup;
import se2_webapp.backend.persistance.model.SlackSetup;
import se2_webapp.backend.persistance.model.User;
import se2_webapp.backend.webClients.GitlabClient;
import se2_webapp.backend.webClients.SlackClient;

@Service
public class ConfigService {
    @Autowired
    GitlabSetupService gitlabSetupService;

    @Autowired
    SlackSetupService slackSetupService;

    @Autowired
    AlertingSetupService alertingSetupService;

    @Autowired
    UserService userService;

    @Autowired
    SlackClient slackClient;

    @Autowired
    GitlabClient gitlabClient;

    public ConfigResponseBody getConfigForm(Long id) {
        GitlabSetup gitlabSetup = this.gitlabSetupService.findGitlabSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no Gitlab Setup available"));
        SlackSetup slackSetup = this.slackSetupService.findSlackSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no Slack Setup available"));
        AlertingSetup alertingSetup = this.alertingSetupService.findAlertingSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no Alerting Setup available"));

        ConfigResponseBody body = new ConfigResponseBody(gitlabSetup, slackSetup, alertingSetup);

        return body;
    }

    public boolean getUserCreatedConfig(Long id) {
        User user = this.userService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        return user.isCreatedConfig();
    }
}
