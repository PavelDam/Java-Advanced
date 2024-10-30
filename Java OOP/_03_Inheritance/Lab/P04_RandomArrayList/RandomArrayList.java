package _03_Inheritance.Lab.P04_RandomArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {


    public Object getRandomElement() {
        int index = ThreadLocalRandom.current().nextInt(0, super.size());
        return get(index);
    }
}
