package task1;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class ReflectTester {

    private static final String NEXT_LINE = System.lineSeparator();

    public static String getClassDescription(Class<?> obj) {
        return  "Package: " + obj.getPackage() + NEXT_LINE +
                "Modifier: " + Modifier.toString(obj.getModifiers()) + NEXT_LINE +
                "ClassName: " + obj.getSimpleName() + NEXT_LINE +
                "ParentClass: " + obj.getSuperclass() + NEXT_LINE +
                "Implemented interfaces: " + Arrays.toString(obj.getInterfaces()) + NEXT_LINE +
                "Fields: " + Arrays.toString(obj.getDeclaredFields()) + NEXT_LINE +
                "Constructors: " + Arrays.toString(obj.getDeclaredConstructors()) + NEXT_LINE +
                "Methods: " + Arrays.toString(obj.getDeclaredMethods()) + NEXT_LINE;
    }

    public static String getClassDescription(String className) throws ClassNotFoundException {
        return getClassDescription(Class.forName(className));
    }

    public static void main(String[] args) {
        String className;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the class name: ");
        className = scanner.nextLine(); // Example: java.util.ArrayList
        try {
            System.out.print(getClassDescription(className));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
