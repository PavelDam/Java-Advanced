package _07_ReflectionAndAnnotation.Exercise.P02_blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Field value = clazz.getDeclaredField("innerValue");
        value.setAccessible(true);

        while (!"END".equals(input)) {
            String[] commandArr = input.split("_");
            String methodType = commandArr[0];
            int argument = Integer.parseInt(commandArr[1]);

            Method method = clazz.getDeclaredMethod(methodType, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, argument);

            System.out.println(value.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
