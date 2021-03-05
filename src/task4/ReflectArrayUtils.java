package task4;

import java.lang.reflect.Array;

public class ReflectArrayUtils {

    private ReflectArrayUtils() {
    }

    public static Object createArray(Class<?> clazz, int length) {
        return Array.newInstance(clazz, length);
    }

    public static Object createMatrix(Class<?> clazz, int rows, int cols) {
        return Array.newInstance(clazz, rows, cols);
    }

    public static Object resizeArray(Object array, int newLength) {
        Class<?> clazzOfOldArray = array.getClass().getComponentType();
        Object newArray = Array.newInstance(clazzOfOldArray, newLength);

        for (int i = 0; i < Math.min(Array.getLength(array), newLength); i++) {
            Array.set(newArray, i, Array.get(array, i));
        }
        return newArray;
    }

    public static Object resizeMatrix(Object matrix, int newRowLength, int newColLength) {
        Class<?> clazzOfOldMatrix = matrix.getClass().getComponentType().getComponentType();
        Object newMatrix = Array.newInstance(clazzOfOldMatrix, newRowLength, newColLength);

        for (int i = 0; i < Math.min(Array.getLength(matrix), newRowLength); i++) {
            for (int j = 0; j < Math.min(Array.getLength(Array.get(matrix, i)), newColLength); j++) {
                Array.set(Array.get(newMatrix, i), j, Array.get(Array.get(matrix, i), j));
            }
        }
        return newMatrix;
    }

    public static String reflectArrayToString(Object array) {

        StringBuilder objectString = new StringBuilder();
        int length = Array.getLength(array);

        objectString.append("[");
        for (int i = 0; i < length; i++) {
            if (Array.get(array, i) == null) {
                objectString.append("null");
            } else if (Array.get(array, i).getClass().isArray()) {
                objectString.append(reflectArrayToString(Array.get(array, i)));
            } else {
                objectString.append(Array.get(array, i).toString());
            }

            if (i != length - 1) {
                objectString.append(", ");
            }
        }
        objectString.append("]");

        return objectString.toString();
    }
}
