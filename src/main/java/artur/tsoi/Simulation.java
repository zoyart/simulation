package artur.tsoi;

import artur.tsoi.actions.Actions;
import artur.tsoi.entities.animals.Herbivore;
import artur.tsoi.map.Map;

import lombok.Getter;

@Getter
public class Simulation {
    private final Map map = new Map();
    public static int STEPS_COUNT;

    public void init() {
        Actions.initActions(this.map);
        System.out.println("Все существа созданы!");
        this.map.renderMatrix();
    }

    public void nextTurn() {
        // TODO добавить список валидаций после каждого хода и их проверка через цикл
        // TODO добавить такой же список с правилами игры, чтобы можно было их легко добавлять и расширять

        // Проверка на полностью заполненое поле
        if (map.getEmptyCellsInMatrix().isEmpty()) {
            System.out.println("Всё поле занято! Симуляция закончена.");
            System.exit(0);
        }

        Actions.turnActions(this.map);
        map.renderMatrix();
        Simulation.incrementStepsCount();

        // Правило окончания игры: травоядные == 0
        if (map.getEntityCountByClass(Herbivore.class) == 0) {
            System.out.println("Симуляция закончена.");
            System.exit(0);
        }
    }

    public static void incrementStepsCount() {
        Simulation.STEPS_COUNT++;
    }
}
