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

    private final int predatorsMaxCount = 5;
    private final int herbivoresMaxCount = 10;

    private final int rockMaxCount = 10;
    private final int grassMaxCount = 10;
    private final int treesMaxCount = 10;
}
