package com.maxim.entities.animals;

import com.maxim.Settings;
import com.maxim.entities.Creature;
import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.entities.objects.Grass;
import com.maxim.entities.objects.Soil;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Herbivore extends Creature {
    private int howEatForReproduction = Settings.HOW_HERBIVORES_EAT_FOR_REPRODUCTION;

    public Herbivore(Coordinate coordinate) {
        super(coordinate);
        super.setIcon("\uD83D\uDC11");
        super.setType(EntityType.HERBIVORE);
        super.setHealth(20);
        super.setDamage(1);
    }

    @Override
    public void makeMove(Map map) {
        Coordinate currentCoordinate = super.coordinate;
        List<Coordinate> pathToGrass = super.findPath(map, HerbivoreBarriersEnum.values(), Grass.class, currentCoordinate);

        // Если путь найден
        if (pathToGrass != null) {
            pathToGrass.removeFirst(); // удаляем координату на которой находится сам.

            // Если путь до ближайшей цели - 1, кушаем. Иначе идём до цели дальше.
            if (pathToGrass.size() == 1) {
                // TODO Тут травоядное ест, красиво бы завернуть это всё в другие методы
                Entity[][] matrix = map.getMatrix();
                Coordinate grassCoordinate = pathToGrass.getLast();
                Grass grass = (Grass) matrix[grassCoordinate.getY()][grassCoordinate.getX()];
                int grassHealth = grass.getHeath();

                if (grassHealth > this.damage) {
                    grass.setHeath(grassHealth - this.damage);
                } else {
                    // Куст съеден
                    map.deleteEntity(grass.getCoordinate());

                    // Проверка на то, достаточно ли животное съело для размножения
                    this.howEatForReproduction--;
                    if (howEatForReproduction == 0) {
                        List<Coordinate> pathToSoil = findPath(map, HerbivoreBarriersEnum.values(), Soil.class, currentCoordinate);

                        if (pathToSoil != null) {
                            Coordinate emptyPlaceForNewHerbivore = pathToSoil.getLast();
                            Herbivore newHerbivore = new Herbivore(emptyPlaceForNewHerbivore);
                            map.spawnEntity(newHerbivore);
                            howEatForReproduction = Settings.HOW_HERBIVORES_EAT_FOR_REPRODUCTION;
                        }
                    }
                }
            } else {
                super.coordinate = pathToGrass.getFirst(); // Устанавливаем новую координату для травоядного
                map.relocateEntity(this, currentCoordinate);
            }
        }
    }
}
