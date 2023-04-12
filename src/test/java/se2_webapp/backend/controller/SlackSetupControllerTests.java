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
import se2_webapp.backend.controller.bodies.SlackSetupRequestBody;
import se2_webapp.backend.persistance.model.SlackSetup;
import se2_webapp.backend.persistance.repository.SlackSetupRepository;
import se2_webapp.backend.service.SlackSetupService;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(SlackSetupController.class)
public class SlackSetupControllerTests {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private SlackSetupService slackSetupService;

    @MockBean
    private SlackSetupRepository slackSetupRepository;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @AfterEach
    public void teardown() {
        slackSetupRepository.deleteAll();
    }

    @Test
    void saveSlackSetupHappy() throws Exception{
        var userId = 1L;
        var testMail = "testmail";
        var testChannelName = "testName";
        var testBaseUrl = "https://sfgfead.de/api/";
        var testToken = "testtoken";

        SlackSetupRequestBody testSetup = new SlackSetupRequestBody();
        testSetup.setUserId(userId);
        testSetup.setEmail(testMail);
        testSetup.setChannelName(testChannelName);
        testSetup.setBaseUrl(testBaseUrl);
        testSetup.setToken(testToken);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/slack-setup/sendSlackFormOnPOST")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(new Gson().toJson(testSetup));

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getSlackConfigHappy() throws Exception{
        var userId = 1L;
        var testMail = "testmail";
        var testChannelName = "testName";
        var testBaseUrl = "https://sfgfead.de/api/";
        var testToken = "testtoken";

        SlackSetup testSetup = new SlackSetup();
        testSetup.setUserId(userId);
        testSetup.setEmail(testMail);
        testSetup.setChannelName(testChannelName);
        testSetup.setBaseUrl(testBaseUrl);
        testSetup.setToken(testToken);

        when(slackSetupService.findSlackSetupByUserId(userId)).thenReturn(Optional.of(testSetup));

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/slack-setup/getConfig?id=" + userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    @Test
    void getSlackBaseUrlHappy() throws Exception{
        var userId = 1L;
        var testMail = "testmail";
        var testChannelName = "testName";
        var testBaseUrl = "https://sfgfead.de/api/";
        var testToken = "testtoken";

        SlackSetup testSetup = new SlackSetup();
        testSetup.setUserId(userId);
        testSetup.setEmail(testMail);
        testSetup.setChannelName(testChannelName);
        testSetup.setBaseUrl(testBaseUrl);
        testSetup.setToken(testToken);

        when(slackSetupService.findSlackSetupByUserId(userId)).thenReturn(Optional.of(testSetup));

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/slack-setup/getBaseUrl?id=" + userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}
