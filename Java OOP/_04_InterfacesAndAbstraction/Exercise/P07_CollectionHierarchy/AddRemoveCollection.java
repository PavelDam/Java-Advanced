package _04_InterfacesAndAbstraction.Exercise.P07_CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {


    @Override
    public int add(String input) {
        getItems().add(0, input);
        return 0;
    }

    @Override
    public String remove() {
        return getItems().remove(getItems().size() - 1);
    }
}
