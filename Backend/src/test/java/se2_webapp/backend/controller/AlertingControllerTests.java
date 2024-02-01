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
import se2_webapp.backend.service.AlertingService;
import se2_webapp.backend.service.AlertingSetupService;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(AlertingController.class)
public class AlertingControllerTests {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AlertingSetupService alertingSetupService;

    @MockBean
    private AlertingService alertingService;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void postAlertHappy() throws Exception{
        var userId = 1L;
        AlertingSetup testAlertingSetup = new AlertingSetup(userId, true, true, true, true);

        when(alertingSetupService.findAlertingSetupByUserId(userId)).thenReturn(Optional.of(testAlertingSetup));

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/alerting/postAlert?id=" + userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}