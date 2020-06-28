package uk.co.asto.interview.cats.port;

import uk.co.asto.interview.cats.domain.model.Fact;

import java.util.List;

public interface FactFetcher {
    List<Fact> fetchAllFacts();
}
