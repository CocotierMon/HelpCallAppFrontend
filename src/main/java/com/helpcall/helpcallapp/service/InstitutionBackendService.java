package com.helpcall.helpcallapp.service;

import com.helpcall.helpcallapp.client.InstitutionBackendClient;
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

    public InstitutionDto getInstitutionById(Long id) {
        return institutionBackendClient.getInstitutionById(id);
    }

    public void deleteInstitution(Long id) {
        institutionBackendClient.deleteInstitutionById(id);
    }

    public void createInstitution(InstitutionDto institutionDto) {
        institutionBackendClient.createInstitution(institutionDto);
    }

    public void updateInstitution(InstitutionDto institutionDto) {
        institutionBackendClient.updateInstitution(institutionDto);
    }
}
