package com.naosim.washlet.statepattern;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.state.*;

public class Washlet_statepattern implements WashletAndPowerLevelAction {
    private final Device device;
    private WashletAction washlet;
    private PowerLevel powerLevel;
    private final WashletStateFactory washletStateFactory = new WashletStateFactory();

    public Washlet_statepattern(Device device) {
        this.device = device;
        updateState(State.waiting);
    }

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

    private void updateState(State state) {
        this.washlet = washletStateFactory.create(state, new Context(this::updateState, device, powerLevel));
    }
}
