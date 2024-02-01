package se2_webapp.backend.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se2_webapp.backend.persistance.model.AlertingSetup;
import se2_webapp.backend.persistance.model.GitlabSetup;
import se2_webapp.backend.persistance.model.SlackSetup;
import se2_webapp.backend.persistance.model.User;
import se2_webapp.backend.service.*;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(ConfigController.class)
public class ConfigControllerTests {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private ConfigService configService;

    @MockBean
    private GitlabSetupService gitlabSetupService;

    @MockBean
    private SlackSetupService slackSetupService;

    @MockBean
    private AlertingSetupService alertingSetupService;

    @MockBean
    private UserService userService;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @Test
    void getConfigFormHappy() throws Exception{
        var userId = 1L;

        var testMail = "testmail";
        var testProjectName = "testName";
        var testProjectID = 23432;
        var testBaseURL = "https://sfgfead.de/";
        var testToken = "testtoken";

        var slackTestMail = "slackTestmail";
        var slackTestChannelName = "testName";
        var slackTestBaseUrl = "https://sfgfead.de/";
        var slackTestToken = "slackTesttoken";

        var testAlert1 = true;
        var testAlert2 = false;
        var testAlert3 = false;
        var testAlert4 = true;

        GitlabSetup gitlabTestSetup = new GitlabSetup();
        gitlabTestSetup.setUserId(userId);
        gitlabTestSetup.setEmail(testMail);
        gitlabTestSetup.setProjectName(testProjectName);
        gitlabTestSetup.setProjectID(testProjectID);
        gitlabTestSetup.setBaseURL(testBaseURL);
        gitlabTestSetup.setToken(testToken);

        SlackSetup slackTestSetup = new SlackSetup();
        slackTestSetup.setUserId(userId);
        slackTestSetup.setEmail(slackTestMail);
        slackTestSetup.setChannelName(slackTestChannelName);
        slackTestSetup.setBaseUrl(slackTestBaseUrl);
        slackTestSetup.setToken(slackTestToken);

        AlertingSetup alertingTestSetup = new AlertingSetup();
        alertingTestSetup.setUserId(userId);
        alertingTestSetup.setPostIssues(testAlert1);
        alertingTestSetup.setPostUpdatedIssues(testAlert2);
        alertingTestSetup.setPostPipelines(testAlert3);
        alertingTestSetup.setPostVariables(testAlert4);

        when(gitlabSetupService.findGitlabSetupByUserId(userId)).thenReturn(Optional.of(gitlabTestSetup));
        when(slackSetupService.findSlackSetupByUserId(userId)).thenReturn(Optional.of(slackTestSetup));
        when(alertingSetupService.findAlertingSetupByUserId(userId)).thenReturn(Optional.of(alertingTestSetup));

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/config/getConfigForm?id=" + userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    @Test
    void getUserCreatedConfigIsFalse() throws Exception{
        var userId = 1L;
        var testMail = "testmail";
        var testUsername = "testUsername";
        var testPassword = "testPassword01!";

        User testUser = new User();
        testUser.setId(userId);
        testUser.setEmail(testMail);
        testUser.setUsername(testUsername);
        testUser.setPassword(testPassword);

        when(userService.findById(userId)).thenReturn(Optional.of(testUser));

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/config/getUserCreatedConfig?id=" + userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}
