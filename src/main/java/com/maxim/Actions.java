package com.maxim;

import java.util.List;

public class Actions {

    public static void initActions() {
        Maps map = new Maps();
        List<Predator> predatorList = map.mapAddPredators(12);
        List<Herbivore> herbivoreList = map.mapAddHerbivores(15);
        map.showTheMap();
        for (Herbivore herbivore : herbivoreList){
            herbivore.makeMove();
        }
        for (Predator predator : predatorList){
            predator.makeMove();
        }
    }

    public static void turnActions() {

    }
}
