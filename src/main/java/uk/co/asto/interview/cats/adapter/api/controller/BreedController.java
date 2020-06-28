package uk.co.asto.interview.cats.adapter.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.asto.interview.cats.adapter.api.model.dto.BreedDTO;
import uk.co.asto.interview.cats.port.core.BreedService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/breeds")
public class BreedController {
    private final BreedService breedService;

    public BreedController(final BreedService breedService) {
        this.breedService = breedService;
    }

    @GetMapping
    public ResponseEntity<List<BreedDTO>> getCatBreeds() {
        return breedService.findBreeds().stream()
                .map(breed -> BreedDTO.builder()
                        .breed(breed.getBreed())
                        .coat(breed.getCoat())
                        .country(breed.getCountry())
                        .origin(breed.getOrigin())
                        .pattern(breed.getPattern())
                        .build())
                .collect(Collectors.collectingAndThen(Collectors.toList(), breedDTOs -> ResponseEntity.ok().body(breedDTOs)));
    }
}
