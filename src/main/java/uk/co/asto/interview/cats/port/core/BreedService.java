package uk.co.asto.interview.cats.port.core;

import uk.co.asto.interview.cats.domain.model.Breed;

import java.util.List;

public interface BreedService {
    List<Breed> findBreeds();
}
