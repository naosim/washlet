package com.naosim.washlet.stateentity;


import com.naosim.washlet.common.WashletAction;
import com.naosim.washlet.stateentity.state.StateAction;

public interface StateUpdater {
    void updateState(StateAction state);
}
