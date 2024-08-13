package artur.tsoi.entities.objects;

import artur.tsoi.entities.Entity;
import artur.tsoi.entities.EntityType;
import artur.tsoi.map.Coordinate;

public class Soil extends Entity {
    public Soil(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("  ");
        super.setType(EntityType.SOIL);
        super.setHasCollision(false);
    }
}
