package _04_InterfacesAndAbstraction.Exercise.P06_MilitaryElite;

public class PrivateImpl extends SoldierImpl {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }
}
