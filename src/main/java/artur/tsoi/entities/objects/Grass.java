package tsoi.artur.entities.objects;

import tsoi.artur.entities.Entity;
import tsoi.artur.entities.EntityType;
import tsoi.artur.map.Coordinate;
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
