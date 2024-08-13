package artur.tsoi.entities;

import artur.tsoi.Settings;
import artur.tsoi.map.Coordinate;
import artur.tsoi.map.Map;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

@Getter
@Setter
public abstract class Creature extends Entity {
    protected int health;
    protected int damage;
    protected boolean isAlive = true;

    protected Creature(Coordinate coordinate) {
        super(coordinate);
    }

    public abstract void makeMove(Map map);

    /**
     * Метод вычисляет кратчайший путь до цели.
     * NOTE1: В координаты пути входит координата самого существа.
     *        Координата на которой стоит искомое сущетсво находиться на последнем индексе списка.
     *
     * @param map карта
     * @param seekerBarriers константы enum
     * @param target класс искомого существа
     * @param start координата существа, которое ищет
     * @return список координат до цели, если пути нет - null
     * @param <T>
     */
    protected <T extends Enum<?>> List<Coordinate> findPath(Map map, T[] seekerBarriers, Class<?> target, Coordinate start) {
        int mapSizeX = Settings.MAP_SIZE_X;
        int mapSizeY = Settings.MAP_SIZE_Y;

        Entity[][] matrix = map.getMatrix();

        Queue<Coordinate> queue = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        java.util.Map<Coordinate, Coordinate> prev = new HashMap<>();

        queue.add(start);
        visited.add(start);
        visited.addAll(map.getAllBarriers(seekerBarriers)); // Добавление в посещаемые все entity с коллизией
        prev.put(start, null);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            Entity currentEntity = matrix[current.getY()][current.getX()];
            int x = current.getX();
            int y = current.getY();

            // Если путь до target найден
            if (target.isInstance(currentEntity)) {
                return reconstructPath(prev, current);
            }

            // Перебор 4-ёх сторон
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // TODO позже можно сделать список валидаций через стратегию (если много их будет).

                if (newX >= 0 && newX < mapSizeX && newY >= 0 && newY < mapSizeY) { // Валидация на выход за поле
                    Coordinate nextCoordinate = new Coordinate(newY, newX);

                    // Если новая координата не посещалась, то помечаем
                    if (!visited.contains(nextCoordinate)) {
                        queue.add(nextCoordinate);
                        visited.add(nextCoordinate);
                        prev.put(nextCoordinate, current);
                    }
                }
            }
        }

        return null;
    }

    private static List<Coordinate> reconstructPath(java.util.Map<Coordinate, Coordinate> prev, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = end;

        while (current != null) {
            path.add(current);
            current = prev.get(current);
        }

        Collections.reverse(path);

        path.removeFirst(); // Удаление координаты на которой сущность находится

        return path;
    }
}
