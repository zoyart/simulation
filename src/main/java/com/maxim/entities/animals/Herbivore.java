package com.maxim.entities.animals;

import com.maxim.entities.Creature;
import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.entities.objects.Grass;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;

import java.util.List;

public class Herbivore extends Creature {
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
            // Если путь до ближайшей цели - 1, атакуем цель. Иначе идём до цели дальше
            if (pathToGrass.size() == 1) {
                Entity[][] matrix = map.getMatrix();
                Coordinate grassCoordinate = pathToGrass.getLast();
                Grass grass = (Grass) matrix[grassCoordinate.getY()][grassCoordinate.getX()];

                // TODO Тут атака, её нужно бы красиво завернуть
                int grassHealth = grass.getHeath();
                if (grassHealth > this.damage) {
                    grass.setHeath(grassHealth - this.damage);
                } else {
                    map.deleteEntity(grass.getCoordinate());
                }
            } else {
                super.coordinate = pathToGrass.getFirst(); // Устанавливаем новую координату для травоядного
                map.relocateEntity(this, currentCoordinate);
            }
        }
    }
}
