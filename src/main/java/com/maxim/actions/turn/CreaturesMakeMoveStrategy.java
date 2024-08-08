package com.maxim.actions.turn;

import com.maxim.actions.Actions;
import com.maxim.entities.Creature;
import com.maxim.entities.animals.Herbivore;
import com.maxim.entities.animals.Predator;
import com.maxim.map.Map;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CreaturesMakeMoveStrategy implements TurnStrategy {
    @Override
    public void turn(Map map) {
        List<Predator> predators = map.getAllEntityByClass(Predator.class);
        List<Herbivore> herbivore = map.getAllEntityByClass(Herbivore.class);

        // Тут описать ходы животных на карте
    }
}
