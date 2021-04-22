package com.helpcall.helpcallapp.service;

import com.helpcall.helpcallapp.client.VolunteersWallBackendClient;
import com.helpcall.helpcallapp.domain.VolunteerWallDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerWallBackendService {

    private final VolunteersWallBackendClient client;

    public List<VolunteerWallDto> getVolunteersWall(Long id) {return client.getVolunteersWall(id);}
}
