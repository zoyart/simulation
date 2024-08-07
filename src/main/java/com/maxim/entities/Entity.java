package com.maxim.entities;

import com.maxim.map.Coordinate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity {
    private EntityType type;
    private String icon;
    private Coordinate coordinate;
}
