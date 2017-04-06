package com.naosim.washlet.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PowerLevel {
    private int value;
    public PowerLevel up() {
        return new PowerLevel(Math.min(value + 1, 5));
    }

    public PowerLevel down() {
        return new PowerLevel(Math.max(value - 1, 1));
    }
}
