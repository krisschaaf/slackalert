package se2_webapp.backend.webClients;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
public class SlackClientTest {
    private static final String BOT_USER_OAUTH_TOKEN = "";
    private static final String CHANNEL_NAME = "slackalert-app";
    private static final String BASE_URL = "https://slack.com/api/";
    private static final String TEST_MESSAGE = "Hello World from IntelliJ";

    @Autowired
    SlackClient slackClient;

    @BeforeEach
    public void setup() {
        slackClient.setValues(BOT_USER_OAUTH_TOKEN, CHANNEL_NAME, BASE_URL);
    }

    @AfterEach
    public void teardown() {
        slackClient.resetValues();
    }

    @Test
    public void sendMessage() {
        assertThat(slackClient.sendMessage(TEST_MESSAGE).block().getOk()).contains("true");
    }
}
