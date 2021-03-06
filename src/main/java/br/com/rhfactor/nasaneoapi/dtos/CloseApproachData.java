package br.com.rhfactor.nasaneoapi.dtos;


import br.com.rhfactor.nasaneoapi.serializers.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Map;

@Data
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CloseApproachData {

    @JsonProperty("close_approach_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate cloaseApproachDate;

    @JsonProperty("relative_velocity")
    Map<String, Double> relativeVelocity;

    @JsonProperty("orbiting_body")
    String orbitingBody;

    public boolean isCloseToEarth() {
        return orbitingBody.equals("Earth");
    }

    public Double getRelativeVelocityKmPerHour(){
        return relativeVelocity.get("kilometers_per_hour").doubleValue();
    }
}
