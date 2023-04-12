package se2_webapp.backend.webClients;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
public class WebClientsBuilderTest {

    @Test
    public void testClientWithOpenCatAPIHappy() {
        WebClient client = WebClient.builder()
                .baseUrl("https://meowfacts.herokuapp.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<String> response = client.get().uri("?count=1")
                .retrieve().bodyToMono(String.class);

        String responseStringBlocked = response.block();
        assertThat(responseStringBlocked).contains("data");
    }
}
