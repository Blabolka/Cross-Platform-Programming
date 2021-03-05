package task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class Main {

    public static void invokeMethod(Object obj, String methodName, Object[] args) {
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName, getParameterTypesFromObjects(args));
            method.setAccessible(true);
            System.out.println(Optional.ofNullable(method.invoke(obj, args)).orElse("*Nothing to show*"));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    private static Class<?>[] getParameterTypesFromObjects(Object[] objects) {
        return Arrays.stream(objects)
                .map(Object::getClass)
                .toArray(Class<?>[]::new);
    }

    public static void main(String[] args) {
        Object[] arguments = { 5 };
        invokeMethod(new TestClass(), "fakeInsert", arguments);
    }
}
