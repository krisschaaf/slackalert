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
import se2_webapp.backend.controller.bodies.AlertingSetupRequestBody;
import se2_webapp.backend.persistance.repository.AlertingSetupRepository;
import se2_webapp.backend.service.AlertingSetupService;

@WebMvcTest(AlertingSetupController.class)
public class AlertingSetupControllerTests {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AlertingSetupService alertingSetupService;

    @MockBean
    private AlertingSetupRepository alertingSetupRepository;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @AfterEach
    public void teardown() {
        alertingSetupRepository.deleteAll();
    }

    @Test
    void saveAlertingSetupHappy() throws Exception{
        var userId = 1L;
        var alert1 = true;
        var alert2 = false;
        var alert3 = false;
        var alert4 = true;

        AlertingSetupRequestBody testSetup = new AlertingSetupRequestBody();
        testSetup.setUserId(userId);
        testSetup.setPostIssues(alert1);
        testSetup.setPostUpdatedIssues(alert2);
        testSetup.setPostPipelines(alert3);
        testSetup.setPostVariables(alert4);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/alerting-setup/sendAlertingFormOnPOST")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(new Gson().toJson(testSetup));

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
