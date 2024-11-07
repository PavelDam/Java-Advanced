package _04_InterfacesAndAbstraction.Lab.P03_P04_SayHello;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
