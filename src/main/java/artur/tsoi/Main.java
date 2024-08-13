package artur.tsoi;

import java.util.Scanner;

/**
 * TODO Текущие траблы:
 * 1. Криво реализованы барьеры, явно задаём правила барьеров в enum.
 * 2. Проблема с передачей большого количества переменных в методы
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.init();

        do {
            simulation.nextTurn();

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
