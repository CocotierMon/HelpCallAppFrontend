package com.helpcall.helpcallapp.client.volunteer;

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
public class VolunteerBeckendClient {

    private final RestTemplate restTemplate;
    private final BackEndConfig backEndConfig;

    public List<VolunteerDto> getAllVolunteers() {
        Optional<VolunteerDto[]> volunteers = Optional.ofNullable(
                restTemplate.getForObject(getVolunteersByUri(), VolunteerDto[].class));
        return volunteers.map(Arrays::asList).orElseGet(ArrayList::new);
    }

    private URI getVolunteersByUri() {
        assert backEndConfig != null;
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
               .port(backEndConfig.getPort())
               .path("/volunteers")
               .encode()
               .build()
               .toUri();
    }
}
