package com.naosim.washlet.strategy;

import com.naosim.washlet.common.EventType;
import com.naosim.washlet.common.State;
import com.sun.tools.javac.util.Pair;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@ToString(includeFieldNames = false)
@EqualsAndHashCode(doNotUseGetters = true)
public class Strategy {
    private final Map<Pair<State, EventType>, State> table;
    private final Consumer<State> stateUpdateAction;
    public Strategy(Consumer<State> stateUpdateAction) {
        this.stateUpdateAction = stateUpdateAction;

        this.table = new HashMap<>();
        table.put(Pair.of(State.waiting, EventType.sitDown), State.ready);

        table.put(Pair.of(State.ready, EventType.standUp), State.waiting);
        table.put(Pair.of(State.ready, EventType.pressedBideButton), State.bide);
        table.put(Pair.of(State.ready, EventType.pressedOshiriButton), State.oshiri);

        table.put(Pair.of(State.bide, EventType.pressedStopButton), State.ready);
        table.put(Pair.of(State.bide, EventType.pressedOshiriButton), State.oshiri);

        table.put(Pair.of(State.oshiri, EventType.pressedStopButton), State.ready);
        table.put(Pair.of(State.oshiri, EventType.pressedBideButton), State.oshiri);
    }

    /**
     * 状態遷移を判定する。状態に変更がある場合、stateUpdateActionに通知する
     * @param state
     * @param eventType
     */
    public void judge(State state, EventType eventType) {
        Optional.ofNullable(table.get(Pair.of(state, eventType))).ifPresent(stateUpdateAction);
    }
}
