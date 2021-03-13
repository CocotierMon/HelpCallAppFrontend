package com.helpcall.helpcallapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.helpcall.helpcallapp.observer.Observer;
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
public class VolunteerDto implements Observer {

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
    @JsonProperty("Needs")
    public List<NeedDto> needs;

    @Override
    public void update(NeedDto needDto) {
        System.out.println("Do listy potrzeb dodano nową potrzebę: " + needDto.getTitle());
    }
}
