package com.naosim.washlet.statepattern;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.state.WashletBide;
import com.naosim.washlet.statepattern.state.WashletOshiri;
import com.naosim.washlet.statepattern.state.WashletReady;
import com.naosim.washlet.statepattern.state.WashletWaiting;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Washlet_statepattern implements WashletAction, PowerLevelAction {
    private final Device device;
    private final StateSetter stateSetter = (state) -> {
        if(State.waiting.equals(state)) {
            this.washlet = new WashletWaiting(this.stateSetter);
        }
        if(State.ready.equals(state)) {
            this.washlet = new WashletReady(this.stateSetter);
        }
        if(State.oshiri.equals(state)) {
            this.washlet = new WashletOshiri(this.stateSetter, device, this.powerLevel);
        }
        if(State.bide.equals(state)) {
            this.washlet = new WashletBide(this.stateSetter, device, this.powerLevel);
        }

    };
    private WashletAction washlet = new WashletWaiting(this.stateSetter);
    private PowerLevel powerLevel;

    public void pressedOshiriButton() {
        washlet.pressedOshiriButton();
    }

    public void pressedBideButton() {
        washlet.pressedBideButton();
    }

    public void pressedStopButton() {
        washlet.pressedStopButton();
    }

    public void pressedPowerUpButton() {
        powerLevel = powerLevel.up();
    }

    public void pressedPowerDownButton() {
        powerLevel = powerLevel.down();
    }



    public void standUp() {
        washlet.standUp();
    }

    public void sitDown() {
        washlet.sitDown();
    }
}
