package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;

public class WashletReady implements WashletAction {
    private final Context context;

    public WashletReady(Context context) {
        this.context = context;
        context.getDevice().stop();
    }

    @Override
    public void pressedOshiriButton() {
        context.getStateUpdater().updateState(State.oshiri);
    }

    @Override
    public void pressedBideButton() {
        context.getStateUpdater().updateState(State.bide);
    }

    @Override
    public void pressedStopButton() {

    }

    @Override
    public void standUp() {
        context.getStateUpdater().updateState(State.waiting);
    }

    @Override
    public void sitDown() {

    }
}
