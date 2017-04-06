package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletBide implements WashletAction {
    private final StateSetter stateSetter;

    public WashletBide(StateSetter stateSetter, Device device, PowerLevel powerLevel) {
        this.stateSetter = stateSetter;
        device.start(powerLevel, Angle.bide);
    }

    @Override
    public void pressedOshiriButton() {
        stateSetter.setWashlet(State.oshiri);
    }

    @Override
    public void pressedBideButton() {
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
