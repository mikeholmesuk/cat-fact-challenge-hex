package uk.co.asto.interview.cats.adapter.client.catFactNinja.dao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataWrapper<T> {
    @JsonProperty(value = "data")
    private final List<T> data;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public DataWrapper(@JsonProperty(value = "data") List<T> data) {
        this.data = data;
    }
}
