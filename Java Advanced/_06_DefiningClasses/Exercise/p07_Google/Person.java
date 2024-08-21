package _06_DefiningClasses.Exercise.P07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Children> childs;
    private List<Pokemon> pokemons;

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParent(Parent parent) {
        if (parents == null) {
            parents = new ArrayList<>();
        }
        parents.add(parent);
    }

    public void addChild(Children child) {
        if (childs == null) {
            childs = new ArrayList<>();
        }
        childs.add(child);
    }

    public void addPokemon(Pokemon pokemon) {
        if (pokemons == null) {
            pokemons = new ArrayList<>();
        }
        pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company:\n");
        if (company != null) {
            sb.append(company).append("\n");
        }

        sb.append("Car:\n");
        if (car != null) {
            sb.append(car).append("\n");
        }

        sb.append("Pokemon:\n");
        if (pokemons != null && !pokemons.isEmpty()) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString()).append("\n");
            }
        }

        sb.append("Parents:\n");
        if (parents != null && !parents.isEmpty()) {
            for (Parent parent : parents) {
                sb.append(parent.toString()).append("\n");
            }
        }

        sb.append("Children:\n");
        if (childs != null && !childs.isEmpty()) {
            for (Children child : childs) {
                sb.append(child.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}
