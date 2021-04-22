package com.helpcall.helpcallapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"Title", "InstitutionName", "EndTime"})
public class VolunteerWallDto {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("EndTime")
    private LocalDate endTime;
    @JsonProperty("InstitutionName")
    private String institutionName;

    @Override
    public String toString() {
        return "VolunteerWallDto{" +
                "title='" + title + '\'' +
                ", endTime=" + endTime +
                ", institutionName='" + institutionName + '\'' +
                '}';
    }
}
