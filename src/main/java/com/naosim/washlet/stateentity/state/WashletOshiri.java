package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.*;

public class WashletOshiri implements StateAction, StateAction.Bide, StateAction.Stop {
    private final Context context;

    public WashletOshiri(Context context) {
        this.context = context;
        context.getDevice().start(context.getPowerLevel(), Angle.oshiri);
    }

    @Override
    public void pressedBideButton() {
        context.getStateUpdater().updateState(new WashletBide(context));
    }

    @Override
    public void pressedStopButton() {
        context.getStateUpdater().updateState(new WashletReady(context));
    }
}
