package com.naosim.washlet.statepattern;

import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;
import com.naosim.washlet.statepattern.state.*;
import lombok.AllArgsConstructor;

import java.util.function.Function;
import java.util.stream.Stream;

public class WashletStateFactory {
    @AllArgsConstructor
    private enum Factory {
        waiting(State.waiting, WashletWaiting::new),
        ready(State.ready, WashletReady::new),
        oshiri(State.oshiri, WashletOshiri::new),
        bide(State.bide, WashletBide::new);

        private final State state;
        private final Function<Context, WashletAction> factory;
        public static Function<Context, WashletAction> getFactory(State state) {
            return Stream.of(Factory.values())
                    .filter(v -> v.state.equals(state))
                    .map(v -> v.factory)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("状態がない"));
        }
    }


    public WashletAction create(State state, Context context) {
        return Factory.getFactory(state).apply(context);
    }
}
