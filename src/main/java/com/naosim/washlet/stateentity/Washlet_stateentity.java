package com.naosim.washlet.stateentity;

import com.naosim.washlet.common.*;
import com.naosim.washlet.stateentity.state.Context;
import com.naosim.washlet.stateentity.state.WashletWaiting;

public class Washlet_stateentity implements WashletAndPowerLevelAction {
    private final WashletWrapper washletWrapper;

    private PowerLevel powerLevel;

    public Washlet_stateentity(Device device) {
        washletWrapper = new WashletWrapper(new WashletWaiting(new Context() {
            @Override
            public StateUpdater getStateUpdater() {
                return washletWrapper;
            }

            @Override
            public Device getDevice() {
                return device;
            }

            @Override
            public PowerLevel getPowerLevel() {
                return powerLevel;
            }
        }));
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
    }

    public void pressedPowerDownButton() {
        powerLevel = powerLevel.down();
    }

    public void standUp() {
        washletWrapper.getStandUpAction().ifPresent(v -> v.standUp());
    }

    public void sitDown() {
        washletWrapper.getSitDownAction().ifPresent(v -> v.sitDown());
    }
}
