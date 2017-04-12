package com.naosim.washlet.stateentity.state;


public class WashletReady implements StateAction, StateAction.Oshiri, StateAction.Bide, StateAction.StandUp {
    private final Context context;

    public WashletReady(Context context) {
        this.context = context;
        context.getDevice().stop();
    }

    public void pressedOshiriButton() {
        context.getStateUpdater().updateState(new WashletOshiri(context));
    }

    public void pressedBideButton() {
        context.getStateUpdater().updateState(new WashletBide(context));
    }

    public void standUp() {
        context.getStateUpdater().updateState(new WashletWaiting(context));
    }

}
