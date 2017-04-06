package com.naosim.washlet.allinone;

import com.naosim.washlet.common.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Washlet_allinone implements WashletAction, PowerLevelAction {
    private final Device device;
    private State state = State.waiting;
    private PowerLevel powerLevel = new PowerLevel(1);


    @Override
    public void pressedOshiriButton() {
        if(State.ready.equals(state) || State.bide.equals(state)) {
            state = State.oshiri;
            device.start(powerLevel, Angle.oshiri);
        }
    }

    @Override
    public void pressedBideButton() {
        if(State.ready.equals(state) || State.oshiri.equals(state)) {
            state = State.bide;
            device.start(powerLevel, Angle.bide);
        }
    }

    @Override
    public void pressedStopButton() {
        if(State.oshiri.equals(state) || State.bide.equals(state)) {
            state = State.ready;
            device.stop();
        }
    }

    @Override
    public void pressedPowerUpButton() {
        powerLevel = powerLevel.up();
    }

    @Override
    public void pressedPowerDownButton() {
        powerLevel = powerLevel.down();
    }

    @Override
    public void standUp() {
        if(State.ready.equals(state)) {
            state = State.waiting;
        }
    }

    @Override
    public void sitDown() {
        if(State.waiting.equals(state)) {
            state = State.ready;
        }
    }
}
