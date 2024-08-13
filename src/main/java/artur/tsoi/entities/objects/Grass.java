package artur.tsoi.entities.objects;

import artur.tsoi.entities.Entity;
import artur.tsoi.entities.EntityType;
import artur.tsoi.map.Coordinate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grass extends Entity {
    private int heath = 2;

    public Grass(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83C\uDF3F");
        super.setType(EntityType.GRASS);
    }
}
