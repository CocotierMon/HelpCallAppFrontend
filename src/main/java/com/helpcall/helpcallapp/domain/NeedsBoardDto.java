package com.helpcall.helpcallapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeedsBoardDto {

    @JsonProperty("Id")
    public Long id;

    @JsonProperty("Title")
    public String title;

    @Override
    public String toString() {
        return "NeedsBoardDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
