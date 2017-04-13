package com.naosim.washlet.eventpattern;

import com.naosim.washlet.common.*;
import com.naosim.washlet.eventpattern.event.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode(doNotUseGetters = true)
@AllArgsConstructor
public class Washlet_event implements WashletAction, PowerLevelAction {

    private final Device device;

    private State state = State.waiting;

    private final Context context = new Context() {
        @Override
        public State getState() {
            return state;
        }

        @Override
        public void updateState(State state) {
            Washlet_event.this.state = state;
            if(State.oshiri.equals(state)) {
                device.start(powerLevel, Angle.oshiri);
            } else if(State.bide.equals(state)) {
                device.start(powerLevel, Angle.bide);
            } else if(State.ready.equals(state)) {
                device.stop();
            }
        }
    };

    private PowerLevel powerLevel = new PowerLevel(1);

    private final SitDown sitDown = new SitDown(context);
    private final StandUp standUp = new StandUp(context);
    private final Stop stop = new Stop(context);
    private final Oshiri oshiri = new Oshiri(context);
    private final Bide bide = new Bide(context);


    @Override
    public void pressedOshiriButton() {
        oshiri.run();
    }

    @Override
    public void pressedBideButton() {
        bide.run();
    }

    @Override
    public void pressedStopButton() {
        stop.run();
    }

    @Override
    public void standUp() {
        standUp.run();
    }

    @Override
    public void sitDown() {
        sitDown.run();
    }

    @Override
    public void pressedPowerUpButton() {
        powerLevel = powerLevel.up();
    }

    @Override
    public void pressedPowerDownButton() {
        powerLevel = powerLevel.down();
    }
}
