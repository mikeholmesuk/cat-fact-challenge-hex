package uk.co.asto.interview.cats.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Breed {
    private final String breed;
    private final String country;
    private final String origin;
    private final String coat;
    private final String pattern;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Breed(
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

    public String getBreed() {
        return breed;
    }

    public String getCountry() {
        return country;
    }

    public String getOrigin() {
        return origin;
    }

    public String getCoat() {
        return coat;
    }

    public String getPattern() {
        return pattern;
    }
}
