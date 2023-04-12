package se2_webapp.backend.webClients;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import se2_webapp.backend.webClients.bodies.slackBodies.Body;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebClientsBuilder {
    public static WebClient createWebClientInstance(String baseUrl, String headerName, String headerValue) {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

        WebClient client = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(headerName, headerValue)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return client;
    }

    public static <T> Mono<T> getResponse(String url, WebClient client, Class<T> clazz) {
        return client.get().uri("/{url}", url)
                .retrieve().bodyToMono(clazz);
    }

    public static <T> Mono<T> postResponse(String url, WebClient client, Body requestBody, Class<T> clazz) {
        return client.post()
                .uri("{url}", url)
                .body(Mono.just(requestBody), requestBody.getClass())
                .retrieve()
                .bodyToMono(clazz);
    }
}
