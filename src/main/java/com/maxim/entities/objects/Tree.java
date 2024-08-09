package com.maxim.entities.objects;

import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.map.Coordinate;

public class Tree extends Entity {
    public Tree(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83C\uDF33");
        super.setType(EntityType.TREE);
    }
}
