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
public class NeedBackendClient {

    private final RestTemplate restTemplate;
    private final BackEndConfig backEndConfig;

    public List<NeedDto> getAllNeeds() {
        Optional<NeedDto[]> needs = Optional.ofNullable(
                restTemplate.getForObject(getNeedsByUri(), NeedDto[].class));
        return needs.map(Arrays::asList).orElseGet(ArrayList::new);
    }

    private URI getNeedsByUri() {
        assert backEndConfig != null;
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/needs")
                .encode()
                .build()
                .toUri();
    }
}
