package _06_DefiningClasses.Exercise.P08_FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthdate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(birthdate).append("\n");
        sb.append("Parents:\n");
        for (Person parent : parents) {
            sb.append(parent.name).append(" ").append(parent.birthdate).append("\n");
        }
        sb.append("Children:\n");
        for (Person child : children) {
            sb.append(child.name).append(" ").append(child.birthdate).append("\n");
        }
        return sb.toString();
    }
}
