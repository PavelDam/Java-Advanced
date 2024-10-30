package _03_Inheritance.Lab.P01_P02_P03;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        System.out.println();
        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.weep();
        System.out.println();
        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
