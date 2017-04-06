package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletReady implements WashletAction {
    private final StateSetter stateSetter;

    public WashletReady(StateSetter stateSetter, Device device) {
        this.stateSetter = stateSetter;
        device.stop();
    }

    @Override
    public void pressedOshiriButton() {
        stateSetter.setWashlet(State.oshiri);
    }

    @Override
    public void pressedBideButton() {
        stateSetter.setWashlet(State.bide);
    }

    @Override
    public void pressedStopButton() {

    }

    @Override
    public void standUp() {
        stateSetter.setWashlet(State.waiting);
    }

    @Override
    public void sitDown() {

    }
}
