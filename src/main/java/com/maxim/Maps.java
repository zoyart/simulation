package com.maxim;

import java.util.*;

public class Maps {
    private Map<Integer, Integer> mapOfPredators = new HashMap<>();
    private Map<Integer, Integer> mapOfHerbivores = new HashMap<>();
    private static String[][] array = new String[15][20];
    private final Random randomizer = new Random();

    public Maps() {
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], " ");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length/4; j++) {
                if (j % 2 != 0){
                    array[randomizer.nextInt(15)][randomizer.nextInt(20)] = "\uD83C\uDF3F";
                } else if (j % 2 == 0){
                    array[randomizer.nextInt(15)][randomizer.nextInt(20)] = "\uD83E\uDEA8";
                }
            }
        }
    }

    public List<Predator> mapAddPredators(int countOfPredators) {
        List<Predator> predators = new ArrayList<>();
        for (int i = 0; i < countOfPredators; i++) {
            predators.add(new Predator());
        }
        for (Predator predator : predators) {
            predator.setY(randomizer.nextInt(15));
            predator.setX(randomizer.nextInt(20));
            mapOfPredators.put(predator.getX(), predator.getY());
            array[predator.getY()][predator.getX()] = "\uD83D\uDC3A";
        }

        return predators;

    }

    public List<Herbivore> mapAddHerbivores(int countOfHerbivores) {
        List<Herbivore> herbivores = new ArrayList<>();
        for (int i = 0; i < countOfHerbivores; i++) {
            herbivores.add(new Herbivore());
        }
        for (Herbivore herbivore : herbivores) {
            herbivore.setY(randomizer.nextInt(15));
            herbivore.setX(randomizer.nextInt(20));
            mapOfHerbivores.put(herbivore.getY(), herbivore.getX());
            array[herbivore.getY()][herbivore.getX()] = "\uD83D\uDC07";
        }
        return herbivores;

    }

    public void showTheMap() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }


}
