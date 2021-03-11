package com.helpcall.helpcallapp.service;

import com.helpcall.helpcallapp.client.VolunteerBackendClient;
import com.helpcall.helpcallapp.domain.VolunteerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerBackendService {

    private final VolunteerBackendClient volunteerBackendClient;

    public List<VolunteerDto> getVolunteers() {
        return volunteerBackendClient.getAllVolunteers();
    }

    public VolunteerDto getVolunteerById(Long id) {return volunteerBackendClient.getVolunteerById(id);}

    public void createVolunteer(VolunteerDto volunteerDto) { volunteerBackendClient.createVolunteer(volunteerDto);}

    public void deleteVolunteer(Long id) { volunteerBackendClient.deleteVolunteerById(id);}

    public void updateVolunteer(VolunteerDto volunteerDto) {
        volunteerBackendClient.updateVolunteer(volunteerDto);
    }
}
