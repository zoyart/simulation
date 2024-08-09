package com.maxim.map;

import com.maxim.Settings;
import com.maxim.Simulation;
import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.entities.animals.Herbivore;
import com.maxim.entities.animals.Predator;
import com.maxim.entities.objects.Soil;
import com.maxim.util.Utils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Map {
    private Entity[][] matrix;
    private List<Coordinate> emptyCellsInMatrix = new ArrayList<>();

    public Map() {
        Settings settings = Settings.getInstance();
        this.matrix = new Entity[settings.getMapSizeX()][settings.getMapSizeY()]; // Задаём размеры матрицы

        fillMatrix();
    }

    /**
     * Метод приводит матрицу в начальное состояние для игры.
     */
    public void fillMatrix() {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.emptyCellsInMatrix.add(new Coordinate(i, j)); // Изначально все координаты свободны
                this.matrix[i][j] = new Soil(new Coordinate(i, j)); // Изначально везде "Земля" которая обозначает отсутсвие объектов.

            }
        }
    }

    /**
     * Метод отвечает за форматированный вывод матрицы на экран.
     */
    public void renderMatrix() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Entity entity = matrix[i][j];
                System.out.print(entity.getIcon() + " ");
            }
            System.out.println();
        }

        int herbivoreCount = getEntityCountByClass(Herbivore.class);
        int predatorCount = getEntityCountByClass(Predator.class);

        System.out.println("Шаг №" + Simulation.STEPS_COUNT);
        System.out.println("Хищников:   " + predatorCount);
        System.out.println("Травоядных: " + herbivoreCount);

    }

    /**
     * Метод отвечает за добавление существа на карту
     * NOTE1: метод автоматически УДАЛЯЕТ переданную координату из списка пустых координат карты.
     * NOTE2: метод не отвечает за валидацию координаты (не проверяет свободна ли она и т.д.).
     *
     * @param entity существо, которое необходимо добавить
     */
    public void spawnEntity(Entity entity) {
        Coordinate entityCoordinate = entity.getCoordinate();
        this.matrix[entityCoordinate.getY()][entityCoordinate.getX()] = entity;

        // Удаление координаты из списка emptyCellsInMatrix.
        if (!Objects.equals(entity.getType().toString(), EntityType.SOIL.toString())) { // Если заспавнилась не земля
            int removeIndex;
            for (int i = 0; i < this.emptyCellsInMatrix.size(); i++) {
                Coordinate checkCoordinate = emptyCellsInMatrix.get(i);
                if (checkCoordinate.equals(entityCoordinate)) {
                    removeIndex = i;
                    emptyCellsInMatrix.remove(removeIndex);
                }
            }
        }
    }

    /**
     * Метод отвечает за удаление существа с карты
     * NOTE1: метод автоматически ДОБАВЛЯЕТ переданную координату в список пустых координат карты.
     * NOTE2: метод не отвечает за валидацию координаты (не проверяет свободна ли она и т.д.).
     *
     * @param coordinate координаты по которым необходимо удалить существо
     */
    public void deleteEntity(Coordinate coordinate) {
        this.matrix[coordinate.getY()][coordinate.getX()] = new Soil(coordinate);
        this.emptyCellsInMatrix.add(coordinate);
    }

    /**
     * Метод перемещает сужность из одной координаты в другую.
     *
     * @param entity сущность, которую нужно переместить
     * @param from из какой координаты переместить
     */
    public void relocateEntity(Entity entity, Coordinate from) {
        this.spawnEntity(entity);
        this.deleteEntity(from);
    }

    /**
     * Метод считает количество определённого существа (подкласс Entity) на карте.
     * Пример: getEntityTypeCount(new Rock) -> 20
     *         getEntityTypeCount(new Grass) -> 10
     *
     * @param targetClass класс существа которое является подкласом Entity
     * @return возвращает количество существ найденных на карте
     */
    public <T> int getEntityCountByClass(Class<T> targetClass) {
        int count = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Entity entity = matrix[i][j];
                count += targetClass.isInstance(entity) ? 1 : 0;
            }
        }
        return count;
    }

    /**
     * Метод возвращает всех животных УКАЗАННОГО класса.
     *
     * @param targetClass класс возвращаемых объектов
     * @return список объектов указанного класса
     * @param <T> класс объекта
     */
    public <T extends Entity> List<T> getAllEntityByClass(Class<T> targetClass) {
        List<T> entities = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Entity entity = matrix[i][j];
                if (targetClass.isInstance(entity)) {
                    entities.add(targetClass.cast(entity));
                }
            }
        }
        return entities;
    }

    /**
     * Метод обрабатывает полученные enum значения и ищет их на карте.
     * Если существо из списка, оно добавляется в барьер.
     *
     * @param necessaryBarriers значения которые попадают под выборку
     * @return возвращает список координат, которые являются препятствием.
     * @param <T> любой тип enum.
     */
    public <T extends Enum<?>> List<Coordinate> getAllBarriers(T[] necessaryBarriers) {
        List<Coordinate> barriers = new ArrayList<>();

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Entity entity = matrix[i][j];
                if (Utils.containsTypeInTypes(entity.getType(), necessaryBarriers)) {
                    barriers.add(entity.getCoordinate());
                }
            }
        }
        return barriers;
    }
}
