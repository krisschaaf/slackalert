package se2_webapp.backend.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
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
import se2_webapp.backend.persistance.model.GitlabSetup;
import se2_webapp.backend.persistance.repository.GitlabSetupRepository;
import se2_webapp.backend.service.GitlabSetupService;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(GitlabSetupController.class)
public class GitlabSetupControllerTests {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private GitlabSetupService gitlabSetupService;

    @MockBean
    private GitlabSetupRepository gitlabSetupRepository;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @AfterEach
    public void teardown() {
        gitlabSetupRepository.deleteAll();
    }

    @Test
    void saveGitlabSetupHappy() throws Exception{
        var userId = 1L;
        var testMail = "testmail";
        var testProjectName = "testName";
        var testProjectID = 23432;
        var testBaseURL = "https://sfgfead.de/";
        var testToken = "testtoken";

        GitlabSetup testSetup = new GitlabSetup();
        testSetup.setUserId(userId);
        testSetup.setEmail(testMail);
        testSetup.setProjectName(testProjectName);
        testSetup.setProjectID(testProjectID);
        testSetup.setBaseURL(testBaseURL);
        testSetup.setToken(testToken);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/gitlab-setup/sendGitlabFormOnPOST")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(new Gson().toJson(testSetup));

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getGitlabConfigHappy() throws Exception{
        var userId = 1L;
        var testMail = "testmail";
        var testProjectName = "testName";
        var testProjectID = 23432;
        var testBaseURL = "https://sfgfead.de/";
        var testToken = "testtoken";

        GitlabSetup testSetup = new GitlabSetup();
        testSetup.setUserId(userId);
        testSetup.setEmail(testMail);
        testSetup.setProjectName(testProjectName);
        testSetup.setProjectID(testProjectID);
        testSetup.setBaseURL(testBaseURL);
        testSetup.setToken(testToken);

        when(gitlabSetupService.findGitlabSetupByUserId(userId)).thenReturn(Optional.of(testSetup));

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/gitlab-setup/getConfig?id=" + userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}
