package uk.co.asto.interview.cats.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Fact {
    @JsonProperty(value = "fact")
    private final String fact;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Fact(@JsonProperty("fact") final String fact) {
        this.fact = fact;
    }

    public String getFact() {
        return fact;
    }
}
