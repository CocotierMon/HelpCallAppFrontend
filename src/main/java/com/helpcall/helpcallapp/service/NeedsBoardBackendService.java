package com.helpcall.helpcallapp.service;

import com.helpcall.helpcallapp.client.volunteer.NeedsBoardBackendClient;
import com.helpcall.helpcallapp.domain.NeedsBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeedsBoardBackendService {

    private final NeedsBoardBackendClient needsBoardBackendClient;

    public List<NeedsBoardDto> getNeedsBoards() {
        return needsBoardBackendClient.getAllNeedsBoards();
    }
}
