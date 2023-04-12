package se2_webapp.backend.webClients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Board;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Issue;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Pipeline;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Variable;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitlabClient {

    private static final String HEADER_NAME = "PRIVATE-TOKEN";
    private static final String URL_PARAM_BOARDS = "boards";
    private static final String URL_PARAM_PIPELINES = "pipelines";
    private static final String URL_PARAM_ISSUES = "issues";
    private static final String URL_PARAM_VARIABLES = "variables";
    private WebClient client;
    private String baseUrl;
    private String accessToken;
    private Integer id;
    private OffsetDateTime dateTimeLastIssueCall;

    public GitlabClient() {
        this.setDateTimeLastIssueCall();
    }

    public void setValues(String baseUrl, String accessToken, Integer id) {
        this.baseUrl = baseUrl + id + "/";
        this.accessToken = accessToken;
        this.id = id;

        this.updateClient();
    }

    public void resetValues() {
        this.baseUrl = "";
        this.accessToken = "";
        this.id = -1;
    }

    private void setDateTimeLastIssueCall() {
        this.dateTimeLastIssueCall = OffsetDateTime.now(ZoneId.of("Z"));
    }

    public void setDateTimeLastIssueCall(OffsetDateTime offsetDateTime) {
        this.dateTimeLastIssueCall = offsetDateTime;
    }

    public String[] getValuesAsStrings() {
        return new String[]{baseUrl, accessToken, String.valueOf(id)};
    }

    private void updateClient() {
        this.client = WebClientsBuilder.createWebClientInstance(this.baseUrl, HEADER_NAME, this.accessToken);
    }

    public Board[] getBoards() {
        return WebClientsBuilder.getResponse(URL_PARAM_BOARDS, this.client, Board[].class).block();
    }

    public Pipeline[] getPipelines() {
        return WebClientsBuilder.getResponse(URL_PARAM_PIPELINES, this.client, Pipeline[].class).block();
    }

    public Issue[] getIssues() {
        return WebClientsBuilder.getResponse(URL_PARAM_ISSUES, this.client, Issue[].class).block();
    }

    public Issue[] getUpdatedIssues() {
        Issue[] nonFilteredIssues = this.getIssues();
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: nonFilteredIssues) {
            if(issue.isNewerThan(this.dateTimeLastIssueCall))
                filteredIssues.add(issue);
        }
        this.setDateTimeLastIssueCall();

        return filteredIssues.toArray(new Issue[filteredIssues.size()]);
    }

    public Variable[] getVariables() {
        return WebClientsBuilder.getResponse(URL_PARAM_VARIABLES, this.client, Variable[].class).block();
    }
}
