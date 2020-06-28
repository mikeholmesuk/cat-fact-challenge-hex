package uk.co.asto.interview.cats.port.core;

import uk.co.asto.interview.cats.domain.model.Fact;

import java.util.List;
import java.util.Optional;

public interface FactService {
    List<Fact> findFacts(final Optional<String> queryTerm);
}
