package com.helpcall.helpcallapp.client.volunteer;

import com.helpcall.helpcallapp.config.BackEndConfig;
import com.helpcall.helpcallapp.domain.NeedsBoardDto;
import com.helpcall.helpcallapp.domain.VolunteerDto;
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
public class NeedsBoardBackendClient {

    private final RestTemplate restTemplate;
    private final BackEndConfig backEndConfig;

    public List<NeedsBoardDto> getAllNeedsBoards() {
        Optional<NeedsBoardDto[]> needsBoards = Optional.ofNullable(
                restTemplate.getForObject(getNeedsBoardsByUri(), NeedsBoardDto[].class));
        return needsBoards.map(Arrays::asList).orElseGet(ArrayList::new);
    }

    private URI getNeedsBoardsByUri() {
        assert backEndConfig != null;
        return UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackEndUrl())
                .port(backEndConfig.getPort())
                .path("/needsBoard")
                .encode()
                .build()
                .toUri();
    }
}
