package com.maxim.map;

import com.maxim.Settings;
import com.maxim.entities.Entity;
import com.maxim.entities.EntityType;
import com.maxim.entities.objects.Soil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void fillMatrix() {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = new Soil(); // Изначально везде "Земля" которая обозначает отсутсвие объектов.
                this.emptyCellsInMatrix.add(new Coordinate(i, j)); // Изначально все координаты свободны
            }
        }
    }

    public void renderMatrix() {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Entity entity = matrix[i][j];
                System.out.print(entity.getIcon() + " ");
            }
            System.out.println();
        }
    }

    public void spawnEntityInMap(Entity entity, Coordinate coordinate) {
        this.matrix[coordinate.getX()][coordinate.getY()] = entity;
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
     * Метод возвращает всех животных на карте УКАЗАННОГО класса.
     *
     * @param targetClass какой тип объектов вернуть
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
}
