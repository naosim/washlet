package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.stateentity.StateUpdater;

public interface Context {
    StateUpdater getStateUpdater();
    Device getDevice();
    PowerLevel getPowerLevel();
}
