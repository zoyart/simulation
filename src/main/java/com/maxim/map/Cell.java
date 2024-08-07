package com.maxim.map;

import com.maxim.entities.Entity;
import com.maxim.entities.objects.Soil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cell {
    Coordinate coordinate;
    Entity entity = new Soil();
    boolean isEmpty = true;

    public Cell(Coordinate coordinate, Entity entity) {
        this.coordinate = coordinate;
        this.entity = entity;
    }

    public Cell(Entity entity) {
        this.entity = entity;
    }

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
