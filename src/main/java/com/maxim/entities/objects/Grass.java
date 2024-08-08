package com.maxim.entities.objects;

import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.map.Map;

public class Grass extends Entity {
    public Grass() {
        super.setIcon("\uD83C\uDF3F");
        super.setType(EntityType.GRASS);
    }
}
