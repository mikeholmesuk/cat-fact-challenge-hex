package uk.co.asto.interview.cats.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Breed {
    private final String breed;
    private final String country;
    private final String origin;
    private final String coat;
    private final String pattern;
}
