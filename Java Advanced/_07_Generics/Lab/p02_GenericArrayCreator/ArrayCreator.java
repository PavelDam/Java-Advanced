package _07_Generics.Lab.P02_GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayCreator<T> {


    public static <T> T[] create(int length, T element) {
        return create(element.getClass(), length, element);
    }

    public static <T> T[] create(Class<?> clazz, int length, T element) {
        T[] arr = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(arr, element);
        return arr;
    }
}
