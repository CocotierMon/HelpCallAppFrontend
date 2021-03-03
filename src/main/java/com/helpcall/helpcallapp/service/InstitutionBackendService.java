package com.helpcall.helpcallapp.service;

import com.helpcall.helpcallapp.client.volunteer.InstitutionBackendClient;
import com.helpcall.helpcallapp.domain.InstitutionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionBackendService {

    private final InstitutionBackendClient institutionBackendClient;

    public List<InstitutionDto> getInstitutions() {
        return institutionBackendClient.getAllInstitutions();
    }
}
