package _06_DefiningClasses.Exercise.P06_PokemonTrainer;



import java.util.List;

public class Trainer {


    private List<Pokemon> pokemonsList;
    private int badges;

    public Trainer(List<Pokemon> pokemonsList) {
        this.pokemonsList = pokemonsList;
        this.badges = 0;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public void addPokemon(Pokemon pokemon) {

        pokemonsList.add(pokemon);
    }

    public void setBadges(int badges) {
        this.badges = badges;

    }

    public int getBadges() {
        return badges;
    }


}
