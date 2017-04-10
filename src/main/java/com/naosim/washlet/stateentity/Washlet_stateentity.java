package com.naosim.washlet.stateentity;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.state.Context;
import lombok.AllArgsConstructor;

public class Washlet_stateentity implements WashletAndPowerLevelAction {
    private final WashletWrapper washletWrapper;

    private PowerLevel powerLevel;

    public Washlet_stateentity(Device device) {
        washletWrapper = new WashletWrapper(device);
    }

    public void pressedOshiriButton() {
        washletWrapper.getOshiriAction().ifPresent(v -> v.pressedOshiriButton());
    }

    public void pressedBideButton() {
        washletWrapper.getBideAction().ifPresent(v -> v.pressedBideButton());
    }

    public void pressedStopButton() {
        washletWrapper.getStopAction().ifPresent(v -> v.pressedStopButton());
    }

    public void pressedPowerUpButton() {
        powerLevel = powerLevel.up();
        washletWrapper.setPowerLevel(powerLevel);
    }

    public void pressedPowerDownButton() {
        powerLevel = powerLevel.down();
        washletWrapper.setPowerLevel(powerLevel);
    }

    public void standUp() {
        washletWrapper.getStandUpAction().ifPresent(v -> v.standUp());
    }

    public void sitDown() {
        washletWrapper.getSitDownAction().ifPresent(v -> v.sitDown());
    }
}
