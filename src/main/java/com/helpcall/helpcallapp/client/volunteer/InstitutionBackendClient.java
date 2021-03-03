package com.helpcall.helpcallapp.client.volunteer;

import com.helpcall.helpcallapp.config.BackEndConfig;
import com.helpcall.helpcallapp.domain.InstitutionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InstitutionBackendClient {

    private final RestTemplate restTemplate;
    private final BackEndConfig backEndConfig;

    public List<InstitutionDto> getAllInstitutions() {
        Optional<InstitutionDto[]> institutions = Optional.ofNullable(
                restTemplate.getForObject(getInstitutionsByUri(), InstitutionDto[].class));
        return institutions.map(Arrays::asList).orElseGet(ArrayList::new);
    }

    private URI getInstitutionsByUri() {
        assert backEndConfig != null;
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/institutions")
                .encode()
                .build()
                .toUri();
    }
}
