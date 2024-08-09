package com.maxim.actions.init;

import com.maxim.Settings;
import com.maxim.entities.objects.Grass;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class InitGrassStrategy implements InitStrategy{
    @Override
    public void init(Map map) {
        int grassMaxCount = Settings.GRASS_MAX_COUNT;
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();

        for (int i = 0; i < grassMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Grass grass = new Grass(coordinate);
            map.spawnEntity(grass);
        }
    }
}
