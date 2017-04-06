package com.naosim.washlet.statepattern;

import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.common.State;

public interface StateSetter {
    void setWashlet(State state);
}
