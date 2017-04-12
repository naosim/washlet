package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.*;


public class WashletBide implements StateAction, StateAction.Oshiri, StateAction.Stop {
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
    public void pressedStopButton() {
        context.getStateUpdater().updateState(new WashletReady(context));
    }
}
