package _07_Generics.Lab.P01_JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> stack = new Jar<>();
        stack.add(13);
        stack.add(5);
        stack.add(3);
        System.out.println(stack.remove());
        System.out.println(stack.remove());

    }
}
