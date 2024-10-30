package _03_Inheritance.Lab.P05_StackOfStrings;

import java.util.ArrayDeque;

public class Stack {
    private ArrayDeque<String> data;

    public Stack() {
        this.data = new ArrayDeque<>();
    }


    public void push(String item) {
        data.push(item);
    }

    public String pop() {
        return data.pop();
    }

    public String peek() {
        return data.peek();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
