package com.maxim.entities.objects;

import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.map.Coordinate;

public class Soil extends Entity {
    public Soil(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("  ");
        super.setType(EntityType.SOIL);
        super.setHasCollision(false);
    }
}
