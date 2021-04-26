package com.helpcall.helpcallapp.client;

import com.helpcall.helpcallapp.config.BackEndConfig;
import com.helpcall.helpcallapp.domain.InstitutionDto;
import com.helpcall.helpcallapp.domain.NeedDto;
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
        Optional<InstitutionDto> institutionDto = Optional.ofNullable(restTemplate.getForObject(getInstitutionsByIdUri(id),
                InstitutionDto.class));
        return institutionDto.orElse(new InstitutionDto());
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
        restTemplate.delete(getInstitutionsByIdUri(id));
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
        restTemplate.put(saveInstitutionByUri(), institutionDto);
    }

    public void addNeed(NeedDto needDto, Long id) {
        restTemplate.put("http://localhost:8080/v1/institutions/addNeed/" + id, needDto, InstitutionDto.class);
    }
}
