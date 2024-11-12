package _04_InterfacesAndAbstraction.Exercise.P07_CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{
    @Override
    public int add(String input) {
        getItems().add(0, input);
        return 0;
    }

    @Override
    public String remove() {
        return getItems().remove(0);
    }

    @Override
    public int getUsed() {
        return getItems().size();
    }
}
