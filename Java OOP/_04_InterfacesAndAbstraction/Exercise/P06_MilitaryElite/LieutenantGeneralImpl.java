package _04_InterfacesAndAbstraction.Exercise.P06_MilitaryElite;

public class LieutenantGeneralImpl extends  PrivateImpl implements Private{
    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }



    @Override
    public void addPrivate() {

    }
}
