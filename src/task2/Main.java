package task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void printFieldsFullInfo(Object obj){
        Class<?> classObj = obj.getClass();
        Field[] fields = classObj.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println("Field: " + field.toString() + ",\tValue: " + field.get(obj));
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    public static void printPublicMethodsFullInfo(Object obj){
        Class<?> classObj = obj.getClass();
        Method[] methods = classObj.getMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.toString());
        }
        System.out.println();
    }

    public static void printClassInfoAndInvokeMethod(Object obj) {
        printFieldsFullInfo(obj);
        System.out.println();
        printPublicMethodsFullInfo(obj);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want you invoke some method without parameters? (y-yes/n-no): ");
        String isInvoke = scanner.nextLine();
        if (isInvoke.toLowerCase().equals("y")) {
            Class<?> classObj = obj.getClass();
            Method[] methods = classObj.getMethods();
            List<Method> methodsWithoutParameters = new ArrayList<>();

            for (int i = 0 ; i < methods.length ; i++) {
                if (methods[i].getParameterCount() == 0) {
                    methodsWithoutParameters.add(methods[i]);
                }
            }

            for (int i = 0; i < methodsWithoutParameters.size(); i++) {
                System.out.println(i + 1 + ". " + methodsWithoutParameters.get(i).toString());
            }

            System.out.print("Choose method by number: ");
            int choose = scanner.nextInt();
            try {
                System.out.println(methodsWithoutParameters.get(choose - 1).invoke(obj));
            } catch (IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        printClassInfoAndInvokeMethod(list);
    }
}
