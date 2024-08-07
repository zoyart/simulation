package com.maxim.entities.objects;

import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;

public class Rock extends Entity {
    public Rock() {
        super.setIcon("\uD83E\uDEA8");
        super.setType(EntityType.ROCK);
    }
}
