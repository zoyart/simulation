package artur.tsoi.entities.animals;

import artur.tsoi.Settings;
import artur.tsoi.entities.Creature;
import artur.tsoi.entities.Entity;
import artur.tsoi.entities.EntityType;
import artur.tsoi.entities.objects.Grass;
import artur.tsoi.entities.objects.Soil;
import artur.tsoi.map.Coordinate;
import artur.tsoi.map.Map;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Herbivore extends Creature {
    private int howEatForReproduction = Settings.HOW_HERBIVORES_EAT_FOR_REPRODUCTION;
    private final int radiusOfInteraction = 1;

    public Herbivore(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83D\uDC11");
        super.setType(EntityType.HERBIVORE);
        super.setHealth(20);
        super.setDamage(1);
    }

    @Override
    public void makeMove(Map map) {
        Coordinate currentCoordinate = new Coordinate(super.getCoordinate());
        List<Coordinate> pathToFood = super.findPath(map, HerbivoreBarriersEnum.values(), Grass.class, currentCoordinate);

        if (pathToFood == null) {
            return;
        }

        // Если расстояние до еды равно радиусу взаимодействия. Иначе идём до цели дальше.
        if (pathToFood.size() == radiusOfInteraction) {
            Coordinate foodCoordinate = pathToFood.getLast();
            eat(map, foodCoordinate);

            if (this.howEatForReproduction == 0) {
                reproduction(map);
            }
        } else {
            super.coordinate = pathToFood.getFirst(); // Устанавливаем новую координату для перемещения
            map.relocateEntity(this, currentCoordinate);
        }
    }

    public void eat(Map map, Coordinate foodCoordinate) {
        Entity[][] matrix = map.getMatrix();
        Grass grass = (Grass) matrix[foodCoordinate.getY()][foodCoordinate.getX()];
        int grassHealth = grass.getHeath();

        if (grassHealth > this.damage) {
            grass.setHeath(grassHealth - this.damage);
        } else {
            // Куст съеден
            map.deleteEntity(grass.getCoordinate());
            this.howEatForReproduction--;
        }
    }

    public void reproduction(Map map) {
        List<Coordinate> pathToSoil = findPath(map, HerbivoreBarriersEnum.values(), Soil.class, super.getCoordinate());

        if (pathToSoil != null) {
            Coordinate emptyPlaceForNewHerbivore = pathToSoil.getLast();
            Herbivore newHerbivore = new Herbivore(emptyPlaceForNewHerbivore);
            map.spawnEntity(newHerbivore);
            howEatForReproduction = Settings.HOW_HERBIVORES_EAT_FOR_REPRODUCTION;
        }
    }
}
