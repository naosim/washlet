package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.StateUpdater;
import com.naosim.washlet.statepattern.state.Context;
import lombok.AllArgsConstructor;

public class WashletOshiri implements StateAction.Bide, StateAction.Stop {
    private final Context context;

    public WashletOshiri(Context context) {
        this.context = context;
        context.getDevice().start(context.getPowerLevel(), Angle.oshiri);
    }

    @Override
    public void pressedBideButton() {
        context.getStateUpdater().updateState(State.bide);
    }

    @Override
    public void pressedStopButton() {
        context.getStateUpdater().updateState(State.ready);
    }
}
