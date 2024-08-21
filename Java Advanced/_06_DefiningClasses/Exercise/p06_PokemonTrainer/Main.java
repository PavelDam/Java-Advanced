package _06_DefiningClasses.Exercise.P06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] inputArr = input.split("\\s+");
            String trainerName = inputArr[0];
            String pokemonName = inputArr[1];
            String pokemonElement = inputArr[2];
            int pokemonHealth = Integer.parseInt(inputArr[3]);

            trainersMap.computeIfAbsent(trainerName, name -> new Trainer(new ArrayList<>()))
                    .addPokemon(new Pokemon(pokemonName, pokemonElement, pokemonHealth));


            input = scanner.nextLine();
        }


        String command = scanner.nextLine();

        while (!command.equals("End")) {

            checkPokemons(trainersMap, command);


            command = scanner.nextLine();
        }
        trainersMap.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().getBadges(), entry1.getValue().getBadges()))
                .forEach(entry -> {
                    String trainerName = entry.getKey();
                    Trainer trainer = entry.getValue();
                    System.out.printf("%s %d %d%n", trainerName, trainer.getBadges(), trainer.getPokemonsList().size());
                });

    }

    private static void checkPokemons(Map<String, Trainer> trainersMap, String command) {
        trainersMap.forEach((name, trainer) -> {
            List<Pokemon> pokemons = trainer.getPokemonsList();
            boolean found = pokemons.stream()
                    .anyMatch(pokemon -> pokemon.getElement().equals(command));

            if (found) {
                trainer.setBadges(trainer.getBadges() + 1);
            } else {
                pokemons.removeIf(pokemon -> {
                    pokemon.setHealth(pokemon.getHealth() - 10);
                    return pokemon.getHealth() <= 0;
                });
            }
        });
    }
}

