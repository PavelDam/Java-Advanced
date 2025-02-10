package _07_ReflectionAndAnnotation.Lab.P01_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz);

        System.out.println(clazz.getSuperclass());

        System.out.println(clazz.getInterfaces()[0]);

        Constructor<Reflection> declaredConstructor = clazz.getDeclaredConstructor();
        Reflection reflection = declaredConstructor.newInstance();
        System.out.println(reflection);
    }
}
