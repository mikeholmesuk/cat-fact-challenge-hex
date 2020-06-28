package uk.co.asto.interview.cats.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.asto.interview.cats.domain.model.Fact;
import uk.co.asto.interview.cats.port.FactFetcher;
import uk.co.asto.interview.cats.port.core.BreedService;
import uk.co.asto.interview.cats.port.core.FactService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Core implements FactService, BreedService {

    private final FactFetcher factFetcher;

    @Autowired
    public Core(final FactFetcher factFetcher) {
        this.factFetcher = factFetcher;
    }

    @Override
    public List<Fact> findFacts(Optional<String> queryTerm) {
        return factFetcher.fetchAllFacts().stream()
                .filter(fact -> queryTerm.isPresent()
                        ? fact.getFact().contains(queryTerm.get())
                        : true)
                .collect(Collectors.toList());
    }
}
