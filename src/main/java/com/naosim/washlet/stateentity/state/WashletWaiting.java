package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletWaiting implements StateAction.SitDown {
    private final StateSetter stateSetter;

    @Override
    public void sitDown() {
        stateSetter.setWashlet(State.ready);
    }
}
