package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletOshiri implements StateAction.Bide, StateAction.Stop {
    private final StateSetter stateSetter;

    public WashletOshiri(StateSetter stateSetter, Device device, PowerLevel powerLevel) {
        this.stateSetter = stateSetter;
        device.start(powerLevel, Angle.oshiri);
    }

    @Override
    public void pressedBideButton() {
        stateSetter.setWashlet(State.bide);
    }

    @Override
    public void pressedStopButton() {
        stateSetter.setWashlet(State.ready);
    }
}
