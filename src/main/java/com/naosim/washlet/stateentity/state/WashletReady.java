package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.State;
import com.naosim.washlet.statepattern.state.Context;

public class WashletReady implements StateAction.Oshiri, StateAction.Bide, StateAction.StandUp {
    private final Context context;

    public WashletReady(Context context) {
        this.context = context;
        context.getDevice().stop();
    }

    public void pressedOshiriButton() {
        context.getStateUpdater().updateState(State.oshiri);
    }

    public void pressedBideButton() {
        context.getStateUpdater().updateState(State.bide);
    }

    public void standUp() {
        context.getStateUpdater().updateState(State.waiting);
    }

}
