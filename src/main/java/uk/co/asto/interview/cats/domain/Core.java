package uk.co.asto.interview.cats.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.asto.interview.cats.domain.model.Breed;
import uk.co.asto.interview.cats.domain.model.Fact;
import uk.co.asto.interview.cats.port.BreedFetcher;
import uk.co.asto.interview.cats.port.FactFetcher;
import uk.co.asto.interview.cats.port.core.BreedService;
import uk.co.asto.interview.cats.port.core.FactService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Core implements FactService, BreedService {

    private final FactFetcher factFetcher;
    private final BreedFetcher breedFetcher;

    @Autowired
    public Core(final FactFetcher factFetcher, final BreedFetcher breedFetcher) {
        this.factFetcher = factFetcher;
        this.breedFetcher = breedFetcher;
    }

    @Override
    public List<Fact> findFacts(Optional<String> queryTerm) {
        return factFetcher.fetchAllFacts().stream()
                .filter(fact -> queryTerm.isPresent()
                        ? fact.getFact().contains(queryTerm.get())
                        : true)
                .collect(Collectors.toList());
    }

    @Override
    public List<Breed> findBreeds() {
        return breedFetcher.fetchAllBreeds();
    }
}
