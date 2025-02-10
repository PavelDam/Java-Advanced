package _07_ReflectionAndAnnotation.Lab.P02_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);
        Set<Method> getters = getMethods(methods, comparator, "get");
        Set<Method> setters = getMethods(methods, comparator, "set");

        getters.forEach(g -> System.out.printf("%s will return class %s%n", g.getName(), g.getReturnType().getName()));
        setters.forEach(s -> System.out.printf("%s and will set field of class %s%n", s.getName(), s.getParameterTypes()[0].getName()));

    }

    private static TreeSet<Method> getMethods(Method[] methods, Comparator<Method> comparator, String type) {
        return Arrays.stream(methods)
                .filter(method -> method.getName().startsWith(type))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

}
