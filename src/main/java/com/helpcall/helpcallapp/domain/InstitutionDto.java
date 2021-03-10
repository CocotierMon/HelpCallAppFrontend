package com.helpcall.helpcallapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstitutionDto {

    @JsonProperty("Id")
    public Long id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("Password")
    public String password;
    @JsonProperty("Latitude")
    public String lat;
    @JsonProperty("Longitude")
    public String lon;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("IsInstitution")
    public String isInstitution;
    @JsonProperty("Needs")
    public List<NeedDto> needs;

    public InstitutionDto(String name, String email, String password, String lat, String lon,
                          String description, String isInstitution, List<NeedDto> needs) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.isInstitution = isInstitution;
        this.needs = needs;
    }

    @Override
    public String toString() {
        return "InstitutionDto{" +
                " name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", description='" + description + '\'' +
                ", isInstitution=" + isInstitution +
                ", needs=" + needs +
                '}';
    }
}
