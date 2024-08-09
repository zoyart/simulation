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
public class InitTreeStrategy implements InitStrategy{
    @Override
    public void init(Map map) {
        int treeMaxCount = Settings.TREES_MAX_COUNT;
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();

        for (int i = 0; i < treeMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Tree tree = new Tree(coordinate);

            map.spawnEntity(tree);
        }
    }
}
