package com.maxim.map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
