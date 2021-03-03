package com.helpcall.helpcallapp.service;

import com.helpcall.helpcallapp.client.VolunteerBeckendClient;
import com.helpcall.helpcallapp.domain.VolunteerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerBackendService {

    private final VolunteerBeckendClient volunteerBeckendClient;

    public List<VolunteerDto> getVolunteers() {
        return volunteerBeckendClient.getAllVolunteers();
    }
}
