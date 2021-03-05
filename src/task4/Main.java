package task4;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        // Test ARRAY
        Class<?> clazz1 = String.class; // need to change this to show how it works on different objects
        Object array1 = ReflectArrayUtils.createArray(clazz1, 7);

        Array.set(array1, 0, "Keep");
        Array.set(array1, 1, "it");
        Array.set(array1, 2, "simple");
        Array.set(array1, 3, "stupid");
        Array.set(array1, 4, "don't");
        Array.set(array1, 5, "repeat");
        Array.set(array1, 6, "yourself");

        array1 = ReflectArrayUtils.resizeArray(array1, 10);

        System.out.println("Testing ARRAY: " +
                System.lineSeparator() +
                ReflectArrayUtils.reflectArrayToString(array1) +
                System.lineSeparator());

        // Test MATRIX
        Class<?> clazz2 = int.class; // need to change this to show how it works on different objects
        Object array2 = ReflectArrayUtils.createMatrix(clazz2, 3, 3);

        Array.set(Array.get(array2, 0), 0, 1);
        Array.set(Array.get(array2, 0), 1, 2);
        Array.set(Array.get(array2, 0), 2, 3);
        Array.set(Array.get(array2, 1), 0, 4);
        Array.set(Array.get(array2, 1), 1, 5);
        Array.set(Array.get(array2, 1), 2, 6);
        Array.set(Array.get(array2, 2), 0, 7);
        Array.set(Array.get(array2, 2), 1, 8);
        Array.set(Array.get(array2, 2), 2, 9);

        array2 = ReflectArrayUtils.resizeMatrix(array2, 4, 4);
        System.out.println("Testing MATRIX: " +
                System.lineSeparator() +
                ReflectArrayUtils.reflectArrayToString(array2) +
                System.lineSeparator());
    }
}
