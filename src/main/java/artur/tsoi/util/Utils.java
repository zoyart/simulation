package tsoi.artur.util;

public class Utils {
    /**
     * Метод проверяем, находится ли type в списке types
     *
     * @param type
     * @param types
     * @return true если type есть в списке types, false если нет
     * @param <T>
     * @param <M>
     */
    public static <T, M> boolean containsTypeInTypes(T type, M[] types) {
        for (M current : types) {
            if (current.toString().equals(type.toString())) {
                return true;
            }
        }
        return false;
    }
}
