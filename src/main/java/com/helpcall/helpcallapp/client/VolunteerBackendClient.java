package com.helpcall.helpcallapp.client;

import com.helpcall.helpcallapp.config.BackEndConfig;
import com.helpcall.helpcallapp.domain.VolunteerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class VolunteerBackendClient {

    private final RestTemplate restTemplate;
    private final BackEndConfig backEndConfig;

    public List<VolunteerDto> getAllVolunteers() {
        Optional<VolunteerDto[]> volunteers = Optional.ofNullable(
                restTemplate.getForObject(getVolunteersByUri(), VolunteerDto[].class));
        return volunteers.map(Arrays::asList).orElseGet(ArrayList::new);
    }

    private URI getVolunteersByUri() {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
               .port(backEndConfig.getPort())
               .path("/volunteers")
               .encode()
               .build()
               .toUri();
    }

    public VolunteerDto getVolunteerById(Long id) {
        Optional<VolunteerDto> volunteer = Optional.ofNullable(
                restTemplate.getForObject(getVolunteerByIdUri(id), VolunteerDto.class)
        );
        return volunteer.orElseGet(VolunteerDto::new);
    }

    private URI getVolunteerByIdUri(Long id) {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/volunteers")
                .queryParam("id", id)
                .encode()
                .build()
                .toUri();
    }

    public void createVolunteer(VolunteerDto volunteerDto) {
        restTemplate.postForObject(saveVolunteerByUri(), volunteerDto, VolunteerDto.class);
    }

    private URI saveVolunteerByUri() {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/volunteers")
                .encode()
                .build()
                .toUri();
    }

    public void deleteVolunteerById(Long id) {
        restTemplate.delete(getVolunteerByIdUri(id));
    }

    public void updateVolunteer(VolunteerDto volunteerDto) {
        restTemplate.put(saveVolunteerByUri(), volunteerDto);
    }
}
