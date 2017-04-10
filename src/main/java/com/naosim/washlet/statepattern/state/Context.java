package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.statepattern.StateUpdater;
import lombok.Value;

@Value
public class Context {
    private final StateUpdater stateUpdater;
    private final Device device;
    private final PowerLevel powerLevel;
}
