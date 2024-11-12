package _04_InterfacesAndAbstraction.Exercise.P07_CollectionHierarchy;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String input) {
        getItems().add(input);
        return getItems().size() - 1;
    }
}
