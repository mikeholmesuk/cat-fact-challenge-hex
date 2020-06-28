package uk.co.asto.interview.cats.adapter.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonDeserialize(builder = FactDTO.FactDTOBuilder.class)
public class FactDTO {
    @JsonProperty(value = "fact")
    private final String fact;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class FactDTOBuilder {}
}
