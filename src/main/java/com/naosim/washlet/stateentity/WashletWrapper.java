package com.naosim.washlet.stateentity;

import com.naosim.washlet.stateentity.state.StateAction;

import java.util.Optional;
import java.util.function.Consumer;

public class WashletWrapper implements StateUpdater {
    private StateAction washlet;

    public WashletWrapper(StateAction stateAction) {
        updateState(stateAction);
    }

    @Override
    public void updateState(StateAction state) {
        this.washlet = state;
    }

    public Optional<StateAction.SitDown> getSitDownAction() {
        return cast(washlet, StateAction.SitDown.class);
    }

    public Optional<StateAction.StandUp> getStandUpAction() {
        return cast(washlet, StateAction.StandUp.class);
    }

    public Optional<StateAction.Oshiri> getOshiriAction() {
        return cast(washlet, StateAction.Oshiri.class);
    }

    public Optional<StateAction.Bide> getBideAction() {
        return cast(washlet, StateAction.Bide.class);
    }

    public Optional<StateAction.Stop> getStopAction() {
        return cast(washlet, StateAction.Stop.class);
    }

    private static <T> Optional<T> cast(Object obj, Class<T> clazz) {
        return Optional.of(obj).filter(clazz::isInstance).map(clazz::cast);
    }

    private static <T> void run(Object obj, Class<T> clazz, Consumer<T> action) {
        cast(obj, clazz).ifPresent(action);
    }
}
