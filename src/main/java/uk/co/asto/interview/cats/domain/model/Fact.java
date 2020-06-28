package uk.co.asto.interview.cats.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Fact {
    private final String fact;
}
