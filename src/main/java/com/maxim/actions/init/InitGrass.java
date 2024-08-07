package com.maxim.actions.init;

import com.maxim.Settings;
import com.maxim.entities.Entity;
import com.maxim.entities.objects.Grass;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class InitGrass implements InitStrategy{
    @Override
    public void init(Map map) {
        Settings settings = Settings.getInstance();

        int grassMaxCount = settings.getGrassMaxCount();
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();
        Entity[][] matrix = map.getMatrix();

        for (int i = 0; i < grassMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Grass grass = new Grass();
            grass.setCoordinate(coordinate);

            matrix[coordinate.getX()][coordinate.getY()] = grass; // Добавление на поле predator
            emptyCells.remove(randomInt);  // Удаление свободной клетки
        }
    }
}
