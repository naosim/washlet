package com.naosim.washlet;

import com.naosim.washlet.allinone.Washlet_allinone;
import com.naosim.washlet.common.Device;
import com.naosim.washlet.common.WashletAndPowerLevelAction;
import com.naosim.washlet.statepatternloosely.Washlet_statepatternloosely;

public class Main {
    public static void main(String[] args) {
        Device device = new Device();
        WashletAndPowerLevelAction washlet = new Washlet_allinone(device);
        new Washlet_statepatternloosely(device);

    }
}
