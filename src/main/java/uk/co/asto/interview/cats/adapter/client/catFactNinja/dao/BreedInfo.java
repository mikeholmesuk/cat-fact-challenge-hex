package uk.co.asto.interview.cats.adapter.client.catFactNinja.dao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BreedInfo {
    private final String breed;
    private final String country;
    private final String origin;
    private final String coat;
    private final String pattern;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BreedInfo(
            @JsonProperty("breed") final String breed,
            @JsonProperty("country") final String country,
            @JsonProperty("origin") final String origin,
            @JsonProperty("coat") final String coat,
            @JsonProperty("pattern") final String pattern) {
        this.breed = breed;
        this.country = country;
        this.origin = origin;
        this.coat = coat;
        this.pattern = pattern;
    }
}
