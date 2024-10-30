package _03_Inheritance.Lab.P05_StackOfStrings;

public class Main {
    public static void main(String[] args) {
        Stack sos = new Stack();

        sos.push("one");
        sos.push("two");
        sos.push("three");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
