package uk.co.asto.interview.cats.adapter.client.catFactNinja.dao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CatFact {
    @JsonProperty(value = "fact")
    private final String fact;
    @JsonProperty(value = "length")
    private final Integer length;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CatFact(@JsonProperty(value = "fact") String fact, @JsonProperty(value = "length") Integer length) {
        this.fact = fact;
        this.length = length;
    }
}
