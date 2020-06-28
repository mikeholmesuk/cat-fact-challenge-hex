package uk.co.asto.interview.cats.controller;

import org.assertj.core.api.SoftAssertions;
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
import uk.co.asto.interview.cats.model.Fact;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Nested
    @DisplayName("/facts endpoint tests")
    class FactsEndpoint {
        @Test
        public void shouldReturnHttp200OnSuccess() throws Exception {
            final ResponseEntity<List<Fact>> response = restTemplate.exchange(
                    "/facts",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        }

        @Test
        public void shouldReturnAllFactsUnfiltered() throws Exception {
            final Integer unfilteredFactsCount = 332;

            final ResponseEntity<List<Fact>> response = restTemplate.exchange(
                    "/facts",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            assertThat(response.getBody()).hasSize(unfilteredFactsCount);
        }
    }

    @Nested
    @DisplayName("/facts endpoint basic features")
    class FactsEndpointFeatures {
        @Test
        public void shouldReturnExpectedFilteredFactsCountWithQueryParameter() throws Exception {
            final Integer filteredFactsCount = 11;
            final String queryParameter = "Egypt";

            final ResponseEntity<List<Fact>> response = restTemplate.exchange(
                    String.format("/facts?q=%s", queryParameter),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            assertThat(response.getBody()).hasSize(filteredFactsCount);
        }

        @Test
        public void shouldReturnEmptyListIfSearchTermDoesNotMatch() {
            final String nonExistentTerm = "DogsAreBetter";

            final ResponseEntity<List<Fact>> response = restTemplate.exchange(
                    String.format("/facts?q=%s", nonExistentTerm),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            assertThat(response.getBody()).isEmpty();
        }

        @Test
        public void shouldReturnAllResultsContainingSearchTerm() {
            final String searchTerm = "Egypt";
            final SoftAssertions softly = new SoftAssertions();

            final ResponseEntity<List<Fact>> response = restTemplate.exchange(
                    String.format("/facts?q=%s", searchTerm),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {});

            response.getBody().stream()
                    .forEach(fact -> softly.assertThat(fact.getFact()).containsIgnoringCase(searchTerm));

            softly.assertAll();
        }
    }
}