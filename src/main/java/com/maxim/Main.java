package com.maxim;

import com.maxim.util.Input;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        simulation.init();

        boolean isNext;
        do {
            // Пока не буддет введено "stop" можно нажимать Enter для пожаговой симуляции
            isNext = Input.userInput(scanner, " ").equals("stop");
            simulation.nextTurn();
        } while (!isNext);
    }
}
