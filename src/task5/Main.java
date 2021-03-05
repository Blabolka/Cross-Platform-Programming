package task5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        NumFunction fun = new NumFunction();
        Class<?> proxy = Proxy.getProxyClass(fun.getClass().getClassLoader(),
                fun.getClass().getInterfaces());

        fun.evalf(1.0);
        try {
            Evaluatable e = (Evaluatable) proxy.getConstructor(InvocationHandler.class).newInstance(new FunHandler(fun));
            e.evalf(1.0);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            ex.printStackTrace();
        }

        Evaluatable e = (Evaluatable) Proxy.newProxyInstance(fun.getClass().getClassLoader(),
                fun.getClass().getInterfaces(), new FunHandler(fun));
        e.evalf(1.0);
        fun.evalf(1.0);
    }
}