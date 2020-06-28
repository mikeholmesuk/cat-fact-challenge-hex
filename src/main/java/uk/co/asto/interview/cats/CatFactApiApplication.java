package uk.co.asto.interview.cats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Core spring boot application for running the Cat Fact Service
 */
@SpringBootApplication
public class CatFactApiApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.rootUri("https://catfact.ninja").build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CatFactApiApplication.class, args);
    }
}
