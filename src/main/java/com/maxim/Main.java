package com.maxim;

import com.maxim.util.Input;

import java.util.Scanner;

public class Main {
    /**
     * TODO Текущие траблы:
     * 1. Криво реализованы барьеры, явно задаём правила барьеров в enum.
     * 2. Проблема с передачей большого количества переменных, можно сделать map - singleton, или подобной штукой.
     *    Таким образом можно повысить читаемость и простоту кода.
     * 3. Доделать генерацию травы, условие плохое, спавнится perTurn больше максимума.
     */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        simulation.init();

        boolean isNext;
        do {
            // Пока не буддет введено "stop" можно нажимать Enter для пошаговой симуляции
//            isNext = Input.userInput(scanner, " ").equals("stop");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            simulation.nextTurn();
        } while (true);
    }
}
