package com.helpcall.helpcallapp.observer;

import com.helpcall.helpcallapp.domain.NeedDto;

public interface Observer {
    void update(NeedDto needDto) throws NoSuchFieldException;
}
