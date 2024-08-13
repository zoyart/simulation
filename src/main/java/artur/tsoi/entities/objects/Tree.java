package artur.tsoi.entities.objects;

import artur.tsoi.entities.Entity;
import artur.tsoi.entities.EntityType;
import artur.tsoi.map.Coordinate;

public class Tree extends Entity {
    public Tree(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83C\uDF33");
        super.setType(EntityType.TREE);
    }
}
