package _06_DefiningClasses.Exercise.P07_Google;

public class Parent {
    private final String parentName;
    private final String parentBirthday;

    public Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return parentName + " " + parentBirthday;
    }
}
