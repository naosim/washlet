package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletWaiting implements WashletAction {
    private final StateSetter stateSetter;

    @Override
    public void pressedOshiriButton() {

    }

    @Override
    public void pressedBideButton() {

    }

    @Override
    public void pressedStopButton() {

    }

    @Override
    public void standUp() {
    }

    @Override
    public void sitDown() {
        stateSetter.setWashlet(State.ready);
    }
}
