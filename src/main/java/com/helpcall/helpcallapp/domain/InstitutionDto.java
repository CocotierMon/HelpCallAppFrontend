package com.helpcall.helpcallapp.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstitutionDto implements Serializable {

    @JsonProperty("Id")
    public Long id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("Password")
    public String password;
    @JsonProperty("Latitude")
    public double lat;
    @JsonProperty("Longitude")
    public double lon;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("IsInstitution")
    public String isInstitution;
    @JsonProperty("Needs")
    public List<NeedDto> needs;

    @Override
    public String toString() {
        return "InstitutionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", description='" + description + '\'' +
                ", isInstitution='" + isInstitution + '\'' +
                ", needs=" + needs +
                '}';
    }

    public Point createPoint(double lat, double lon, String name) {
        return new Point(lat, lon, name);
    }

    public InstitutionDto(double lat, double lon, String name) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }
}
