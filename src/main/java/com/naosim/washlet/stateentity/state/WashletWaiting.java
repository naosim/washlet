package com.naosim.washlet.stateentity.state;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletWaiting implements StateAction, StateAction.SitDown {
    private final Context context;

    @Override
    public void sitDown() {
        context.getStateUpdater().updateState(new WashletReady(context));
    }
}
