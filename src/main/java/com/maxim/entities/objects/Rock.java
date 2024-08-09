package com.maxim.entities.objects;

import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.map.Coordinate;

public class Rock extends Entity {
    public Rock(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83E\uDEA8");
        super.setType(EntityType.ROCK);
    }
}
