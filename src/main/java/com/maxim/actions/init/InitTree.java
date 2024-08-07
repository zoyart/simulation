package com.maxim.actions.init;

import com.maxim.Settings;
import com.maxim.entities.Entity;
import com.maxim.entities.objects.Tree;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class InitTree implements InitStrategy{
    @Override
    public void init(Map map) {
        Settings settings = Settings.getInstance();

        int treeMaxCount = settings.getTreesMaxCount();
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();
        Entity[][] matrix = map.getMatrix();

        for (int i = 0; i < treeMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Tree tree = new Tree();
            tree.setCoordinate(coordinate);

            matrix[coordinate.getX()][coordinate.getY()] = tree; // Добавление на поле predator
            emptyCells.remove(randomInt);  // Удаление свободной клетки
        }
    }
}
