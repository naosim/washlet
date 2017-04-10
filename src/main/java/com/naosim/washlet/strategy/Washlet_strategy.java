package com.naosim.washlet.strategy;

import com.naosim.washlet.common.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode(doNotUseGetters = true)
@AllArgsConstructor
public class Washlet_strategy  implements WashletAndPowerLevelAction {
    private State state = State.waiting;
    private PowerLevel powerLevel = new PowerLevel(1);
    private final Device device;
    private final Strategy strategy = new Strategy(this::updateState);

    @Override
    public void pressedOshiriButton() {
        strategy.judge(state, EventType.pressedOshiriButton);
    }

    @Override
    public void pressedBideButton() {
        strategy.judge(state, EventType.pressedBideButton);
    }

    @Override
    public void pressedStopButton() {
        strategy.judge(state, EventType.pressedStopButton);
    }

    @Override
    public void standUp() {
        strategy.judge(state, EventType.standUp);
    }

    @Override
    public void sitDown() {
        strategy.judge(state, EventType.standUp);
    }

    @Override
    public void pressedPowerUpButton() {
        powerLevel = powerLevel.up();
    }

    @Override
    public void pressedPowerDownButton() {
        powerLevel = powerLevel.down();
    }

    public void updateState(State state) {
        this.state = state;
        switch (state) {
            case ready:
                device.stop();
                break;
            case bide:
                device.start(powerLevel, Angle.oshiri);
                break;
            case oshiri:
                device.start(powerLevel, Angle.bide);
                break;
        }
    }
}
