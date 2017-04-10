package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.StateUpdater;
import com.naosim.washlet.statepattern.state.Context;
import lombok.AllArgsConstructor;

public class WashletBide implements StateAction.Oshiri, StateAction.Stop {
    private final Context context;

    public WashletBide(Context context) {
        this.context = context;
        context.getDevice().start(context.getPowerLevel(), Angle.bide);
    }

    @Override
    public void pressedOshiriButton() {
        context.getStateUpdater().updateState(State.oshiri);
    }

    @Override
    public void pressedStopButton() {
        context.getStateUpdater().updateState(State.ready);
    }
}
