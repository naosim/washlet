package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletOshiri implements WashletAction {
    private final StateSetter stateSetter;

    public WashletOshiri(StateSetter stateSetter, Device device, PowerLevel powerLevel) {
        this.stateSetter = stateSetter;
        device.start(powerLevel, Angle.oshiri);
    }

    @Override
    public void pressedOshiriButton() {
    }

    @Override
    public void pressedBideButton() {
        stateSetter.setWashlet(State.bide);
    }

    @Override
    public void pressedStopButton() {
        stateSetter.setWashlet(State.ready);
    }

    @Override
    public void standUp() {
    }

    @Override
    public void sitDown() {
    }
}
