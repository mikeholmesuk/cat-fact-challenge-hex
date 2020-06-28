package uk.co.asto.interview.cats.port;

import uk.co.asto.interview.cats.domain.model.Breed;

import java.util.List;

public interface BreedFetcher {
    List<Breed> fetchAllBreeds();
}
