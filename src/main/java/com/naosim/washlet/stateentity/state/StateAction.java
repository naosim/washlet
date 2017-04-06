package com.naosim.washlet.stateentity.state;

import com.naosim.washlet.common.State;

public class StateAction {
    public interface Oshiri {
        void pressedOshiriButton();
    }
    public interface Bide {
        void pressedBideButton();
    }
    public interface Stop {
        void pressedStopButton();
    }
    public interface StandUp {
        void standUp();
    }
    public interface SitDown {
        void sitDown();
    }
}
