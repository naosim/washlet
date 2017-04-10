package com.naosim.washlet.stateentity;

import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.common.State;
import com.naosim.washlet.stateentity.state.*;
import com.naosim.washlet.statepattern.StateUpdater;
import com.naosim.washlet.statepattern.state.Context;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class WashletWrapper implements StateUpdater {
    private Object washlet;
    private final Device device;
    @Setter
    private PowerLevel powerLevel = new PowerLevel(1);

    public WashletWrapper(Device device) {
        this.device = device;
        updateState(State.waiting);
    }

    @AllArgsConstructor
    private enum Factory {
        waiting(State.waiting, WashletWaiting::new),
        ready(State.ready, WashletReady::new),
        oshiri(State.oshiri, WashletOshiri::new),
        bide(State.bide, WashletBide::new);

        private final State state;
        private final Function<Context, Object> factory;
        public static Function<Context, Object> getFactory(State state) {
            return Stream.of(Factory.values())
                    .filter(v -> v.state.equals(state))
                    .map(v -> v.factory)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("状態がない"));
        }
    }

    @Override
    public void updateState(State state) {
        this.washlet = Factory.getFactory(state).apply(new Context(this, device, powerLevel));
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
