package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.statepattern.StateUpdater;
import lombok.Value;

public interface Context {
    StateUpdater getStateUpdater();
    Device getDevice();
    PowerLevel getPowerLevel();
}
