package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.State;
import com.naosim.washlet.statepattern.StateUpdater;
import com.naosim.washlet.statepattern.state.Context;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletWaiting implements StateAction.SitDown {
    private final Context context;

    @Override
    public void sitDown() {
        context.getStateUpdater().updateState(State.ready);
    }
}
