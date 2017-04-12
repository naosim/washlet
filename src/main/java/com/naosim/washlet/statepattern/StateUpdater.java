package com.naosim.washlet.statepattern;


import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;

public interface StateUpdater {
    void updateState(WashletAction state);
}
