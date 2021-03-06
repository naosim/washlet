package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.Angle;
import com.naosim.washlet.common.WashletAction;

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
        context.getStateUpdater().updateState(new WashletBide(context));
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
