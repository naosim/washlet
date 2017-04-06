package com.naosim.washlet.stateentity;

import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.PowerLevel;
import com.naosim.washlet.common.State;
import com.naosim.washlet.common.WashletAction;
import com.naosim.washlet.stateentity.state.*;
import com.naosim.washlet.statepattern.StateSetter;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
public class WashletRepository implements StateSetter {
    private Object washlet = new WashletWaiting(this);
    private final Device device;
    @Setter
    private PowerLevel powerLevel = new PowerLevel(1);

    @Override
    public void setWashlet(State state) {
        if(State.waiting.equals(state)) {
            this.washlet = new WashletWaiting(this);
        }
        if(State.ready.equals(state)) {
            this.washlet = new WashletReady(this);
        }
        if(State.oshiri.equals(state)) {
            this.washlet = new WashletOshiri(this, device, this.powerLevel);
        }
        if(State.bide.equals(state)) {
            this.washlet = new WashletBide(this, device, this.powerLevel);
        }
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
}
