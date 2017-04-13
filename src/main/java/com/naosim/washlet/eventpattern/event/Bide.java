package com.naosim.washlet.eventpattern.event;

import com.naosim.washlet.common.State;
import com.naosim.washlet.eventpattern.Context;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode(doNotUseGetters = true)
@AllArgsConstructor
public class Bide implements Runnable {
    private final Context context;

    @Override
    public void run() {
        if(State.ready.equals(context.getState()) || State.oshiri.equals(context.getState())) {
            context.updateState(State.bide);
        }
    }
}
