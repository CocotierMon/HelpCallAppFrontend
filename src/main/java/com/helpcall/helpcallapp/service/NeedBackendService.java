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
}
