package se2_webapp.backend.webClients;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Board;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Issue;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Pipeline;
import se2_webapp.backend.webClients.bodies.gitlabBodies.Variable;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
public class GitlabClientTest {
    private static final String BASE_URL = "https://git.haw-hamburg.de/api/v4/projects/"; //baseUrl + id + "/"
    private static final String ACCESS_TOKEN = "doesntWorkAnyway";
    private static final int ID = 27565;
    @Autowired
    GitlabClient gitlabClient;

    @BeforeEach
    public void setup() {
        gitlabClient.setValues(BASE_URL, ACCESS_TOKEN, ID);
    }

    @AfterEach
    public void teardown() {
        gitlabClient.resetValues();
    }

    @Test
    public void getBoard() {
        Board[] boards = gitlabClient.getBoards();
        assertThat(boards).hasSizeGreaterThan(0);
    }

    @Test
    public void getPipeline() {
        Pipeline[] pipelines = gitlabClient.getPipelines();
        assertThat(pipelines).hasSizeGreaterThan(0);
        assertThat(pipelines[0].toString()).contains("Pipeline with id");
    }

    @Test
    public void getIssues() {
        Issue[] issues = gitlabClient.getIssues();
        assertThat(issues).hasSizeGreaterThan(0);
        assertThat(issues[0].toString()).contains("Issue with id");
    }

    @Test
    public void getUpdatedIssues() {
        gitlabClient.setDateTimeLastIssueCall(OffsetDateTime.parse("2022-11-17T11:58:55.419+01:00"));
        Issue[] issues = gitlabClient.getUpdatedIssues();
        assertThat(issues).hasSizeGreaterThan(0);
        assertThat(issues[0].toString()).contains("Issue with id");
    }

    @Test
    public void getVariables() {
        Variable[] variables = gitlabClient.getVariables();
        assertThat(variables).hasSizeGreaterThan(0);
        assertThat(variables[0].toString()).contains("Variables with type");
    }
}
