package uk.co.asto.interview.cats.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.co.asto.interview.cats.model.Breed;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BreedControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Nested
    @DisplayName("/breeds endpoint")
    class BreedsEndpoint {
        @Test
        public void shouldReturnHttp200OnSuccess() throws Exception {
            final ResponseEntity<List<Breed>> response = restTemplate.exchange(
                    "/breeds",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        }

        @Test
        public void shouldReturnAllBreedsUnfiltered() {
            final Integer expectedNumberOfBreeds = 25;

            final ResponseEntity<List<Breed>> response = restTemplate.exchange(
                    "/breeds",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            assertThat(response.getBody()).hasSize(expectedNumberOfBreeds);
        }
    }

    @Nested
    @DisplayName("/breeds endpoint basic features")
    class BreedsFeatures {
        @Test
        public void shouldReturnSpecifiedBreedsWithLimitParam() throws Exception {
            final Integer numberToFetch = 10;

            final ResponseEntity<List<Breed>> response = restTemplate.exchange(
                    String.format("/breeds?limit=%d", numberToFetch),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            assertThat(response.getBody()).hasSize(numberToFetch);
        }

        @Test
        public void shouldReturnEmptyListIfLimitIsZero() {
            final Integer numberToFetch = 0;

            final ResponseEntity<List<Breed>> response = restTemplate.exchange(
                    String.format("/breeds?limit=%d", numberToFetch),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            assertThat(response.getBody()).isEmpty();
        }
    }
}