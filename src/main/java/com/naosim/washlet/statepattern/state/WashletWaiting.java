package com.naosim.washlet.statepattern.state;

import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WashletWaiting implements WashletAction {
    private final Context context;

    @Override
    public void pressedOshiriButton() {

    }

    @Override
    public void pressedBideButton() {

    }

    @Override
    public void pressedStopButton() {

    }

    @Override
    public void standUp() {
    }

    @Override
    public void sitDown() {
        context.getStateUpdater().updateState(State.ready);
    }
}
