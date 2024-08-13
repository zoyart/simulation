package artur.tsoi.entities;

import artur.tsoi.map.Coordinate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity {
    protected static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    protected EntityType type;
    protected String icon;
    protected Coordinate coordinate;
    protected boolean hasCollision = true;

    protected Entity(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
