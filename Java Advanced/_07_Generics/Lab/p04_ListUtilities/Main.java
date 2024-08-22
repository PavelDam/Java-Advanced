package _07_Generics.Lab.P04_ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = List.of("1","2","3","4","5");
        System.out.println(ListUtils.getMin(list));
    }
}
