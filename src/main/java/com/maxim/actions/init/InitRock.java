package com.maxim.actions.init;

import com.maxim.Settings;
import com.maxim.entities.Entity;
import com.maxim.entities.objects.Rock;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;

import java.util.List;
import java.util.Random;

public class InitRock implements InitStrategy {
    public InitRock() {}

    @Override
    public void init(Map map) {
        Settings settings = Settings.getInstance();

        int rockMaxCount = settings.getRockMaxCount();
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();
        Entity[][] matrix = map.getMatrix();

        for (int i = 0; i < rockMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Rock rock = new Rock();
            rock.setCoordinate(coordinate);

            matrix[coordinate.getX()][coordinate.getY()] = rock; // Добавление на поле predator
            emptyCells.remove(randomInt);  // Удаление свободной клетки
        }
    }
}
