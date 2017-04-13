package com.naosim.washlet.eventpattern.event;

import com.naosim.washlet.common.State;
import com.naosim.washlet.eventpattern.Context;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode(doNotUseGetters = true)
@AllArgsConstructor
public class Stop implements Runnable {
    private final Context context;

    @Override
    public void run() {
        if(State.oshiri.equals(context.getState()) || State.bide.equals(context.getState())) {
            context.updateState(State.waiting);
        }
    }
}
