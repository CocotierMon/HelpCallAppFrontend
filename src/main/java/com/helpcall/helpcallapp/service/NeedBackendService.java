package com.helpcall.helpcallapp.service;

import com.helpcall.helpcallapp.client.NeedBackendClient;
import com.helpcall.helpcallapp.domain.NeedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeedBackendService {

    private final NeedBackendClient needBackendClient;

    public List<NeedDto> getNeeds() {
        return needBackendClient.getAllNeeds();
    }

    public NeedDto getNeedById(Long id) { return needBackendClient.getNeedById(id);}

    public void createNeed(NeedDto needDto) { needBackendClient.saveNeed(needDto);}

    public void updateNeed(NeedDto needDto) { needBackendClient.updateNeed(needDto);}

    public void deleteNeed(Long id) { needBackendClient.deleteNeed(id);}
}
