package com.helpcall.helpcallapp.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class NeedDto implements Serializable {

    @JsonProperty("Id")
    public Long id;
    @JsonProperty("Title")
    public String title;
    @JsonProperty("EndTime")
    private LocalDate endTime;
    @JsonProperty("Volunteers")
    private List<VolunteerDto> volunteers;
    @JsonProperty("Done")
    public boolean done;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Latitude")
    public String lat;
    @JsonProperty("Longitude")
    public String lon;
    @JsonIgnore
    private InstitutionDto institution;

    @Override
    public String toString() {
        return "NeedDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", endTime=" + endTime +
                ", volunteers=" + volunteers +
                ", done=" + done +
                ", description='" + description + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
               // ", institution=" + institution +
                '}';
    }
}
