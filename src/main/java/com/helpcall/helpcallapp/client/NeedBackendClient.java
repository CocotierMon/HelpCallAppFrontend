package com.helpcall.helpcallapp.client;

import com.helpcall.helpcallapp.config.BackEndConfig;
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
public class NeedBackendClient {

    private final RestTemplate restTemplate;
    private final BackEndConfig backEndConfig;

    public List<NeedDto> getAllNeeds() {
        Optional<NeedDto[]> needs = Optional.ofNullable(
                restTemplate.getForObject(getNeedsByUri(), NeedDto[].class));
        return needs.map(Arrays::asList).orElseGet(ArrayList::new);
    }

    private URI getNeedsByUri() {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/needs")
                .encode()
                .build()
                .toUri();
    }

    public NeedDto getNeedById(Long id) {
        Optional<NeedDto> need = Optional.ofNullable(
                restTemplate.getForObject(getNeedsByIdUri(id), NeedDto.class)
        );
        return need.orElseGet(NeedDto::new);
    }

    private URI getNeedsByIdUri(Long id) {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/needs")
                .queryParam("id", id)
                .encode()
                .build()
                .toUri();
    }

    public void saveNeed(NeedDto needDto) {
        restTemplate.postForObject(saveNeedByUri(), needDto, NeedDto.class);
    }

    private URI saveNeedByUri() {
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/needs")
                .encode()
                .build()
                .toUri();
    }

    public void updateNeed(NeedDto needDto) {
        restTemplate.put(saveNeedByUri(),needDto);
    }

    public void deleteNeed(Long id) {
        restTemplate.delete(getNeedsByIdUri(id));
    }
}
