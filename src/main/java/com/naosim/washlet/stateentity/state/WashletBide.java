package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletBide implements StateAction.Oshiri, StateAction.Stop {
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
    public void pressedStopButton() {
        stateSetter.setWashlet(State.ready);
    }
}
