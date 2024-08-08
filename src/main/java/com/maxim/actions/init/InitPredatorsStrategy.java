package com.maxim.actions.init;

import com.maxim.Settings;
import com.maxim.entities.Entity;
import com.maxim.entities.animals.Predator;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class InitPredatorsStrategy implements InitStrategy {
    @Override
    public void init(Map map) {
        Settings settings = Settings.getInstance();

        int predatorsMaxCount = settings.getPredatorsMaxCount();
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();

        for (int i = 0; i < predatorsMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Predator predator = new Predator();
            predator.setCoordinate(coordinate);

            map.spawnEntity(predator);

        }
    }
}
