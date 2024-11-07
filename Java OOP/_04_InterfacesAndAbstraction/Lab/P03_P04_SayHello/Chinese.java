package _04_InterfacesAndAbstraction.Lab.P03_P04_SayHello;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
