package com.helpcall.helpcallapp.client;

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
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/institutions")
                .encode()
                .build()
                .toUri();
    }

    public InstitutionDto getInstitutionById(Long id) {
        Optional<InstitutionDto> institution = Optional.ofNullable(
                restTemplate.getForObject(getInstitutionsByIdUri(id), InstitutionDto.class)
        );
        return institution.orElseGet(InstitutionDto::new);
    }

    private URI getInstitutionsByIdUri(Long id) {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/institutions")
                .queryParam("id", id)
                .encode()
                .build()
                .toUri();
    }

    public void deleteInstitutionById(Long id) {
        restTemplate.delete(deleteInstitutionByIdUri(id));
    }

    private URI deleteInstitutionByIdUri(Long id) {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/institutions")
                .queryParam("id", id)
                .encode()
                .build()
                .toUri();
    }

    public void createInstitution(InstitutionDto institutionDto) {
        restTemplate.postForObject(saveInstitutionByUri(), institutionDto, InstitutionDto.class);
    }

    private URI saveInstitutionByUri() {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/institutions")
                .encode()
                .build()
                .toUri();
    }

    public void updateInstitution(InstitutionDto institutionDto) {
        restTemplate.put(updateInstitutionByUri(), institutionDto);
    }

    private URI updateInstitutionByUri() {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/institutions")
                .encode()
                .build()
                .toUri();
    }
}
