package artur.tsoi.entities.objects;

import artur.tsoi.entities.Entity;
import artur.tsoi.entities.EntityType;
import artur.tsoi.map.Coordinate;

public class Rock extends Entity {
    public Rock(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83E\uDEA8");
        super.setType(EntityType.ROCK);
    }
}
