package tsoi.artur.entities.objects;

import tsoi.artur.entities.Entity;
import tsoi.artur.entities.EntityType;
import tsoi.artur.map.Coordinate;

public class Tree extends Entity {
    public Tree(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83C\uDF33");
        super.setType(EntityType.TREE);
    }
}
