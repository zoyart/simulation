package artur.tsoi.entities.animals;

import lombok.Getter;
import artur.tsoi.entities.Creature;
import artur.tsoi.entities.Entity;
import artur.tsoi.entities.EntityType;
import artur.tsoi.map.Coordinate;
import artur.tsoi.map.Map;

import java.util.List;

@Getter
public class Predator extends Creature {
    private final int radiusOfInteraction = 1;

    public Predator(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83E\uDD81");
        super.setType(EntityType.PREDATOR);
        super.setHealth(20);
        super.setDamage(5);
    }

    @Override
    public void makeMove(Map map) {
        Coordinate currentCoordinate = new Coordinate(super.getCoordinate());
        List<Coordinate> pathToHerbivore = super.findPath(map, PredatorBarriersEnum.values(), Herbivore.class, currentCoordinate);

        if (pathToHerbivore == null) {
            return;
        }

        // Если расстояние до еды равно радиусу взаимодействия. Иначе идём до цели дальше.
        if (pathToHerbivore.size() == radiusOfInteraction) {
            Entity[][] matrix = map.getMatrix();
            Coordinate attackedCoordinate = pathToHerbivore.getLast();
            Creature attacked = (Creature) matrix[attackedCoordinate.getY()][attackedCoordinate.getX()];

            attack(map, attacked);
        } else {
            super.coordinate = pathToHerbivore.getFirst(); // Устанавливаем новую координату для перемещения
            map.relocateEntity(this, currentCoordinate);
        }
    }

    public void attack(Map map, Creature attacked) {
        int attackedHealth = attacked.getHealth();
        if (attackedHealth > this.damage) {
            attacked.setHealth(attackedHealth - this.damage);
        } else {
            attacked.setAlive(false); // Помечаем что животное мертво, чтобы оно не сходило в текущем ходу
            map.deleteEntity(attacked.getCoordinate());
        }
    }
}
