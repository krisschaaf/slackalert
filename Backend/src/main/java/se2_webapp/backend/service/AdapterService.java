package se2_webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se2_webapp.backend.persistance.model.GitlabSetup;
import se2_webapp.backend.persistance.model.SlackSetup;
import se2_webapp.backend.webClients.GitlabClient;
import se2_webapp.backend.webClients.SlackClient;

@Service
public class AdapterService {
    @Autowired
    GitlabClient gitlabClient;

    @Autowired
    SlackClient slackClient;

    @Autowired
    GitlabSetupService gitlabSetupService;

    @Autowired
    SlackSetupService slackSetupService;

    public void connectGitlabAdapter(Long id) {
        GitlabSetup gitlabSetup = gitlabSetupService.findGitlabSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no Gitlab Setup available"));
        gitlabClient.setValues(gitlabSetup.getBaseURL(), gitlabSetup.getToken(), gitlabSetup.getProjectID());
    }

    public void connectSlackAdapter(Long id) {
        SlackSetup slackSetup = slackSetupService.findSlackSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no Slack Setup available"));
        slackClient.setValues(slackSetup.getToken(), slackSetup.getChannelName(), slackSetup.getBaseUrl());
    }

    public void setAdapters(Long id) {
        try {
            this.connectGitlabAdapter(id);
            this.connectSlackAdapter(id);
        } catch (ResponseStatusException ex) {
            this.gitlabClient.setValues(null, null, null);
            this.slackClient.setValues(null, null, null);
        }
    }
    public void resetAdapters() {
        this.gitlabClient.resetValues();
        this.slackClient.resetValues();
    }
}
