package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletReady implements StateAction.Oshiri, StateAction.Bide, StateAction.StandUp {
    private final StateSetter stateSetter;

    public WashletReady(StateSetter stateSetter, Device device) {
        this.stateSetter = stateSetter;
        device.stop();
    }

    public void pressedOshiriButton() {
        stateSetter.setWashlet(State.oshiri);
    }

    public void pressedBideButton() {
        stateSetter.setWashlet(State.bide);
    }

    public void standUp() {
        stateSetter.setWashlet(State.waiting);
    }

}
