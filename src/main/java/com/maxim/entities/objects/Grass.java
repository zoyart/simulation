package com.maxim.entities.objects;

import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.map.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grass extends Entity {
    private int heath = 2;

    public Grass() {
        super.setIcon("\uD83C\uDF3F");
        super.setType(EntityType.GRASS);
    }
}
