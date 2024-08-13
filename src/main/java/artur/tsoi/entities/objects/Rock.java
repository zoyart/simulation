package tsoi.artur.entities.objects;

import tsoi.artur.entities.Entity;
import tsoi.artur.entities.EntityType;
import tsoi.artur.map.Coordinate;

public class Rock extends Entity {
    public Rock(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83E\uDEA8");
        super.setType(EntityType.ROCK);
    }
}
