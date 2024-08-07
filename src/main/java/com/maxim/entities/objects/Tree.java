package com.maxim.entities.objects;

import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;

public class Tree extends Entity {
    public Tree() {
        super.setIcon("\uD83C\uDF33");
        super.setType(EntityType.TREE);
    }
}
