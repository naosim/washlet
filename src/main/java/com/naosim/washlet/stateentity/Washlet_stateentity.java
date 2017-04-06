package com.naosim.washlet.stateentity;

import com.naosim.washlet.common.*;
import com.naosim.washlet.statepattern.StateSetter;
import com.naosim.washlet.statepattern.state.WashletBide;
import com.naosim.washlet.statepattern.state.WashletOshiri;
import com.naosim.washlet.statepattern.state.WashletReady;
import com.naosim.washlet.statepattern.state.WashletWaiting;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Washlet_stateentity implements WashletAction, PowerLevelAction {
    private final WashletRepository washletRepository;

    private PowerLevel powerLevel;

    public void pressedOshiriButton() {
        washletRepository.getOshiriAction().ifPresent(v -> v.pressedOshiriButton());
    }

    public void pressedBideButton() {
        washletRepository.getBideAction().ifPresent(v -> v.pressedBideButton());
    }

    public void pressedStopButton() {
        washletRepository.getStopAction().ifPresent(v -> v.pressedStopButton());
    }

    public void pressedPowerUpButton() {
        washletRepository.setPowerLevel(powerLevel.up());
    }

    public void pressedPowerDownButton() {
        washletRepository.setPowerLevel(powerLevel.down());
    }



    public void standUp() {
        washletRepository.getStandUpAction().ifPresent(v -> v.standUp());
    }

    public void sitDown() {
        washletRepository.getSitDownAction().ifPresent(v -> v.sitDown());
    }
}
