package Pokemons;

import java.util.ArrayList;
import java.util.List;

public class PokemonsMain {
  public static void main(String[] args) {
    List<Pokemon> pokemonOfAsh = initializePokemons();

    // Every pokemon has a name and a type.
    // Certain types are effective against others, e.g. water is effective against fire.

    // Ash has a few pokemon.
    // A wild pokemon appeared!

    Pokemon wildPokemon = new Pokemon("Oddish", "leaf", "water");

    // Which pokemon should Ash use?

    String pokemonName = null;
    for (Pokemon index: pokemonOfAsh) {
      if ((index.type != wildPokemon.effectiveAgainst) && (index.effectiveAgainst == wildPokemon.type)) {
        pokemonName = index.name;
        break;
      }
    }


    System.out.print("I choose you, " + pokemonName);
  }

  private static List<Pokemon> initializePokemons() {
    List<Pokemon> pokemon = new ArrayList<>();

    pokemon.add(new Pokemon("Balbasaur", "leaf", "water"));
    pokemon.add(new Pokemon("Pikatchu", "electric", "water"));
    pokemon.add(new Pokemon("Charizard", "fire", "leaf"));
    pokemon.add(new Pokemon("Balbasaur", "water", "fire"));
    pokemon.add(new Pokemon("Kingler", "water", "fire"));

    return pokemon;
  }

}