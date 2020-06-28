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
@JsonDeserialize(builder = BreedDTO.BreedDTOBuilder.class)
public class BreedDTO {
    @JsonProperty(value = "breed")
    private final String breed;
    @JsonProperty("country")
    private final String country;
    @JsonProperty("origin")
    private final String origin;
    @JsonProperty("coat")
    private final String coat;
    @JsonProperty("pattern")
    private final String pattern;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class BreedDTOBuilder {}
}
