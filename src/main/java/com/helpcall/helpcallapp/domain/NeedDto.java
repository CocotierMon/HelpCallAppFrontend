package com.helpcall.helpcallapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeedDto {

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
    @JsonProperty("Institution")
    private InstitutionDto institution;
    @JsonProperty("NeedsBoards")
    private List<NeedsBoardDto> needsBoards;
}
