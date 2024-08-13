package tsoi.artur.entities.objects;

import tsoi.artur.entities.Entity;
import tsoi.artur.entities.EntityType;
import tsoi.artur.map.Coordinate;

public class Soil extends Entity {
    public Soil(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("  ");
        super.setType(EntityType.SOIL);
        super.setHasCollision(false);
    }
}
