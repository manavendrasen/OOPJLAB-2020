import java.util.*;
import java.io.*;

class Pokemon {
  private String name; // Name of the Pokemon
  private int id; // id of the Pokemon
  private String type; // type of the Pokemon

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public void getPokemon() {
    System.out.println("#" + id + "\n" + name + "\n" + type);
  }

  @Override
  public String toString() {
    return (id + " " + name + " " + type);
  }

  Pokemon(String pokemon) {
    // Assuming a correct parameter has been passed.
    StringTokenizer st = new StringTokenizer(pokemon, ";|");
    if (pokemon.indexOf("|") == -1) {
      this.id = Integer.parseInt(st.nextToken());
      this.name = st.nextToken();
      this.type = st.nextToken();
    } else {
      this.name = st.nextToken();
      this.id = Integer.parseInt(st.nextToken());
      this.type = st.nextToken();
    }
  }
} //

class Pokeball {
  private Pokemon pokemon;

  public Pokemon getPokemon() {
    return pokemon;
  }

  public void setPokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  Pokeball(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  @Override
  public String toString() {
    return this.pokemon.toString();
  }
}

class Trainer {
  public static Vector<Pokeball> collection = new Vector<Pokeball>(); // list of
  // pokeballs

  public static void capturePokemon(Pokemon pokemon) {
    /*
     * This method captures a pokemon with a pokeball and adds to the trainer’s
     * collection
     */
    Pokeball p = new Pokeball(pokemon);
    collection.add(p);
  }

  public static Pokemon[] getPokemonWithType(String type) {
    /*
     * This method returns all the pokemonswith given type. If no such pokemon is
     * found then it returns null.
     */
    Pokemon result[] = new Pokemon[10];
    int index = 0;
    for (int i = 0; i < collection.size(); i++) {
      if (collection.get(i).getPokemon().getType().equals(type)) {
        result[index++] = collection.get(i).getPokemon();
      }
    }
    return result;
  }

  public static Pokemon[] getPokemonsWithGivenTypes(String[] types) {
    /*
     * This method returns all the pokemonswhose type matches with one of the types
     * given in the array types[]. If no such pokemons is found then it returns
     * null.
     */
    Pokemon result[] = new Pokemon[20];
    int index = 0;
    for (int i = 0; i < collection.size(); i++) {
      for (int j = 0; j < types.length; j++) {
        if (collection.get(i).getPokemon().getType().equals(types[j])) {
          result[index++] = collection.get(i).getPokemon();
        }
      }
    }
    return result;
  }

  public static Pokemon[] getPokemonsInRange(int minId, int maxId) {
    /*
     * This method returns all the pokemons whose id falls between minId and maxId
     * (both parameters inclusive)
     */
    Pokemon result[] = new Pokemon[10];
    int index = 0;
    for (int i = 0; i < collection.size(); i++) {
      int id = collection.get(i).getPokemon().getId();
      if (id >= minId && id <= maxId) {
        result[index++] = collection.get(i).getPokemon();
      }
    }
    return result;
  }
}

class Test {
  public static Pokemon readPokemon() throws IOException {
    /*
     * This method reads the pokemon details and returns the Pokemon instance.
     * Values to be read from System.in are: 1. Name of Pokemon, 2. Id of Pokemon,
     * 3. Type of the Pokemon, 4. Name format (1 for pipe(|) separated and 2 for
     * semicolon separated)
     */

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Pokemon Details: ");
    String input1 = sc.next();
    Pokemon pk = new Pokemon(input1);
    return pk;
  } // End of readPokemon() Method

  public static void main(String args[]) throws IOException {
    /*
     * 1. Write java code for reading details of 15pokemons and add them in the
     * static list of Trainer class.
     */
    System.out.print("Enter 15 Pokemon: \n");

    for (int i = 1; i <= 15; i++) {
      Trainer.capturePokemon(Test.readPokemon());
    }

    /*
     * 2. Write java code for displaying all the Pokemons with type “Fire” from
     * static list field of Trainer class
     */
    System.out.print("\nCaptured Pokemon of type Fire are: ");
    Pokemon array[] = Trainer.getPokemonWithType("Fire");
    int i = 0;
    while (array[i] != null) {
      System.out.print(array[i++].getName() + " ");
    }

    /*
     * 3. Write java code for displaying the Pokemons with types “Grass”, “Fire”,
     * “Bug”, “Water” from static list of Trainer class
     */

    System.out.print("\nCaptured Pokemon of type Grass, Fire, Bug, Water are: ");
    String[] types = { "Grass", "Fire", "Bug", "Water" };
    Pokemon array2[] = Trainer.getPokemonsWithGivenTypes(types);
    i = 0;
    while (array2[i] != null) {
      System.out.print(array2[i++].getName() + " ");
    }
    /*
     * 4. Write java code for displaying all the pokemons whose id falls in the
     * range minId = 13 and maxId = 26 from static list of Trainer class
     */
    System.out.print("\nPokemon in range 13 to 26 are : ");
    Pokemon array3[] = Trainer.getPokemonsInRange(13, 26);
    i = 0;
    while (array3[i] != null) {
      System.out.print(array3[i++].getName() + " ");
    }
  }// End of main() Method
}// End of Test