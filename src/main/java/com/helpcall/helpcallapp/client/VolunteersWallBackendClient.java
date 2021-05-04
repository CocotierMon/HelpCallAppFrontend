package com.helpcall.helpcallapp.client;

import com.helpcall.helpcallapp.domain.VolunteerWallDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VolunteersWallBackendClient {

    private final RestTemplate restTemplate;

    public List<VolunteerWallDto> getVolunteersWall(Long id) {
        Optional<VolunteerWallDto[]> volunteersWall = Optional.ofNullable(
                restTemplate.getForObject("http://localhost:8080/v1/wall/" + id, VolunteerWallDto[].class));
        return volunteersWall.map(Arrays::asList).orElseGet(ArrayList::new);
    }
}
