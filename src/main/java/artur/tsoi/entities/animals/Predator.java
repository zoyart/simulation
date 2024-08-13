package tsoi.artur.entities.animals;

import tsoi.artur.entities.Creature;
import tsoi.artur.entities.Entity;
import tsoi.artur.entities.EntityType;
import tsoi.artur.map.Coordinate;
import tsoi.artur.map.Map;
import lombok.Getter;

import java.util.List;

@Getter
public class Predator extends Creature {
    public Predator(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83E\uDD81");
        super.setType(EntityType.PREDATOR);
        super.setHealth(20);
        super.setDamage(5);
    }

    @Override
    public void makeMove(Map map) {
        Coordinate currentCoordinate = super.coordinate;
        List<Coordinate> pathToHerbivore = super.findPath(map, PredatorBarriersEnum.values(), Herbivore.class, currentCoordinate);

        // Если путь найден
        if (pathToHerbivore != null) {
            pathToHerbivore.removeFirst(); // удаляем координату на которой находится сам.
            // Если путь до ближайшей цели - 1, атакуем цель. Иначе идём до цели дальше
            if (pathToHerbivore.size() == 1) {
                Entity[][] matrix = map.getMatrix();
                Coordinate attackedCoordinate = pathToHerbivore.getLast();
                Creature attacked = (Creature) matrix[attackedCoordinate.getY()][attackedCoordinate.getX()];

                attack(map, attacked);
            } else {
                super.coordinate = pathToHerbivore.getFirst(); // Устанавливаем новую координату для хищника
                map.relocateEntity(this, currentCoordinate);
            }

        }
    }
}
