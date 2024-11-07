package _04_InterfacesAndAbstraction.Lab.P03_P04_SayHello;

public class European extends BasePerson {


    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
