package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletOshiri implements WashletAction {
    private final Context context;

    public WashletOshiri(Context context) {
        this.context = context;
        context.getDevice().start(context.getPowerLevel(), Angle.oshiri);
    }

    @Override
    public void pressedOshiriButton() {
    }

    @Override
    public void pressedBideButton() {
        context.getStateUpdater().updateState(State.bide);
    }

    @Override
    public void pressedStopButton() {
        context.getStateUpdater().updateState(State.ready);
    }

    @Override
    public void standUp() {
    }

    @Override
    public void sitDown() {
    }
}
