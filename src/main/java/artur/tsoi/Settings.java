package artur.tsoi;

import lombok.Getter;

@Getter
public class Settings {
    public static final int MAP_SIZE_X = 15;
    public static final int MAP_SIZE_Y = 15;

    public static final int PREDATORS_MAX_COUNT = 10;

    public static final int HERBIVORES_MIN_COUNT = 10;
    public static final int HOW_HERBIVORES_EAT_FOR_REPRODUCTION = 1;

    public static final int ROCK_MAX_COUNT = 40;

    public static final int TREES_MAX_COUNT = 10;

    public static final int GRASS_MAX_COUNT = 20;
    public static final int GRASS_PER_TURN = 10;
}
