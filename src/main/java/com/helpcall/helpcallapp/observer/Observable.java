package com.helpcall.helpcallapp.observer;

import com.helpcall.helpcallapp.domain.NeedDto;

public interface Observable {

    void registerObserver(Observer observer);
    void notifyObservers(NeedDto needDto) throws NoSuchFieldException;
    void removeObserver(Observer observer);
}
