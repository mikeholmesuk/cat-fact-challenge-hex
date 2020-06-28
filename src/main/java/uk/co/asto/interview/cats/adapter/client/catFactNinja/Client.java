package uk.co.asto.interview.cats.adapter.client.catFactNinja;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.co.asto.interview.cats.adapter.client.catFactNinja.dao.CatFact;
import uk.co.asto.interview.cats.adapter.client.catFactNinja.dao.DataWrapper;
import uk.co.asto.interview.cats.domain.model.Fact;
import uk.co.asto.interview.cats.port.FactFetcher;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Client implements FactFetcher {
    private final RestTemplate restTemplate;

    public Client(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Fact> fetchAllFacts() {
        return restTemplate.exchange(
                "/facts?limit=1000",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<DataWrapper<CatFact>>() {})
                .getBody().getData().stream()
                .map(catFact -> Fact.builder().fact(catFact.getFact()).build())
                .collect(Collectors.toList());
    }
}
