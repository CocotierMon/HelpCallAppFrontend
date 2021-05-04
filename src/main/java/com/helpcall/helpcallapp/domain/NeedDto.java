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
    public double lat;
    @JsonProperty("Longitude")
    public double lon;
    @JsonIgnore
    private InstitutionDto institution;

    public NeedDto(double lat, double lon, String title) {
        this.lat = lat;
        this.lon = lon;
        this.title = title;
    }

    public Point createPoint(double lat, double lon, String name) {
        return new Point(lat, lon, name);
    }

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
