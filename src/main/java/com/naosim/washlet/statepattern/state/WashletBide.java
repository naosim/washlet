package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.Angle;
import com.naosim.washlet.common.WashletAction;

public class WashletBide implements WashletAction {
    private final Context context;

    public WashletBide(Context context) {
        this.context = context;
        context.getDevice().start(context.getPowerLevel(), Angle.bide);
    }

    @Override
    public void pressedOshiriButton() {
        context.getStateUpdater().updateState(new WashletOshiri(context));
    }

    @Override
    public void pressedBideButton() {
    }

    @Override
    public void pressedStopButton() {
        context.getStateUpdater().updateState(new WashletReady(context));
    }

    @Override
    public void standUp() {
    }

    @Override
    public void sitDown() {

    }
}
