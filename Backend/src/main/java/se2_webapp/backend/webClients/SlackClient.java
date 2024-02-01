package se2_webapp.backend.webClients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import se2_webapp.backend.webClients.bodies.slackBodies.MessageRequestBody;
import se2_webapp.backend.webClients.bodies.slackBodies.MessageResponseBody;

@Service
public class SlackClient {
    private static final String HEADER_NAME = "Authorization";
    private static final String SEND_MESSAGE_URL = "chat.postMessage";
    private WebClient client;
    private String baseURL;
    private String channelName;
    private String botUserOAuthToken;

    public void setValues(String botUserOAuthToken, String channelName, String baseURL) {
        this.botUserOAuthToken = "Bearer " + botUserOAuthToken;
        this.channelName = channelName;
        this.baseURL = baseURL + "/";

        this.updateClient();
    }

    public void resetValues() {
        this.botUserOAuthToken = "";
        this.channelName = "";
        this.baseURL = "";
    }
    public String[] getValuesAsStrings() {
        return new String[]{this.botUserOAuthToken, this.channelName, this.baseURL};
    }

    private void updateClient() {
        this.client = WebClientsBuilder.createWebClientInstance(this.baseURL, HEADER_NAME, this.botUserOAuthToken);
    }

    public Mono<MessageResponseBody> sendMessage(String message) {
        MessageRequestBody messageRequestBody = new MessageRequestBody(this.channelName, message);
        return WebClientsBuilder.postResponse(SEND_MESSAGE_URL, client, messageRequestBody, MessageResponseBody.class);
    }
}
