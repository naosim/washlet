package com.naosim.washlet.statepatternloosely.state;

import com.naosim.washlet.common.*;

public class WashletBide implements WashletAction {
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
    public void pressedBideButton() {
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
