package _07_ReflectionAndAnnotation.Lab.P03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));

        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.printf("%s must be private!%n", field.getName());
            }
        }

        Comparator<Method> comparator = Comparator.comparing(Method::getName);
        Set<Method> getters = getMethods(clazz, comparator, "get");
        Set<Method> setters = getMethods(clazz, comparator, "set");

        for (Method getter : getters) {
            int modifier = getter.getModifiers();
            if (!Modifier.isPublic(modifier)) {
                System.out.printf("%s have to be public!%n", getter.getName());
            }
        }

        for (Method setter : setters) {
            int modifier = setter.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.printf("%s have to be private!%n", setter.getName());
            }
        }


    }

    private static TreeSet<Method> getMethods(Class<Reflection> clazz, Comparator<Method> comparator, String methodType) {
        return Arrays.stream(clazz.getDeclaredMethods()).filter(m -> m.getName().startsWith(methodType)).collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
}