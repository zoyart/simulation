package com.maxim;

import lombok.Getter;

@Getter
public class Settings {
    private static Settings instance;
    private Settings() {}
    public static Settings getInstance() {
        if (instance == null) {
            return new Settings();
        }
        return instance;
    }

    private final int mapSizeX = 10;
    private final int mapSizeY = 10;

    private final int predatorsMaxCount = 1;
    private final int herbivoresMaxCount = 2;

    private final int rockMaxCount = 20;
    private final int treesMaxCount = 10;

    private final int grassMaxCount = 4;
    private final int grassPerTurn = 5;
}
