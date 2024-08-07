package com.maxim.map;

import com.maxim.Settings;
import com.maxim.entities.Entity;
import com.maxim.entities.objects.Soil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
        // TODO
//        System.out.print("\r");
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Entity entity = matrix[i][j];
                System.out.print(entity.getIcon() + " ");
            }
            System.out.println();
        }
    }
}
