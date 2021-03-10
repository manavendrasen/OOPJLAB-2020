import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class Player {

  // Each player has a list of moves stored in movelist
  // Depends on the type of player - batsman or bowler
  ArrayList<Move> movelist = new ArrayList<Move>();

  public ArrayList<Move> getMovelist() {
    return movelist;
  }

  public void setMovelist(ArrayList<Move> movelist) {
    this.movelist = movelist;
  }
}

// Each move ex. Helicopter Shot has a name property
class Move {
  private String name;

  Move(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}

// A batsman in cricket "IS A" player so we use inheritance and extend the
// player class.
class Batsman extends Player {

  // Property - run has the runs scored by the batsman
  private int run;

  // These are the moves the batsman can make
  // These are later added to the movelist
  Move sq = new Move("Square Drive");
  Move hs = new Move("Helicopter Shot");
  Move rs = new Move("Reverse Sweep");

  Batsman() {
    ArrayList<Move> moves = new ArrayList<Move>();
    moves.add(sq);
    moves.add(hs);
    moves.add(rs);

    // We added the moves, now the batsman has the ability to perform shots.
    this.setMovelist(moves);

    // Initializing the runs to 0
    this.run = 0;
  }

  // The player chooses the shot to be played
  public int hit() throws IndexOutOfBoundsException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Choose Shot: ");
    // we display all the shots available to the player
    for (int i = 0; i < this.movelist.size(); i++) {
      System.out.println("-- " + (i + 1) + " " + this.movelist.get(i));
    }
    System.out.print("Enter value: ");

    int userinp = sc.nextInt() - 1;

    if (userinp >= this.movelist.size())
      throw new IndexOutOfBoundsException("Invalid Choice");
    return userinp;
  }

  public int getRun() {
    return this.run;
  }

  // this increments the current runs made by the player
  public int updateRun(int increment) {
    this.run += increment;
    return (this.run);
  }

  public void setRun(int run) {
    this.run = run;
  }
}

// Bowler class "IS A" player, so we inherit player class
class Bowler extends Player {
  // These are the moves the bowler can make
  Move gg = new Move("Googly");
  Move sw = new Move("Swing");
  Move yo = new Move("Yorker");

  Bowler() {
    ArrayList<Move> moves = new ArrayList<Move>();
    moves.add(gg);
    moves.add(yo);
    moves.add(sw);
    // We added the moves, now the bowler has the ability to perform deliveries.
    this.setMovelist(moves);
  }

  // This function basically tells us if the bowler could out the batsman
  // In our case, the bowler is the comp, so we used a random number generator
  public boolean bowl(int shot) {
    Random rand = new Random();
    int choice = rand.nextInt(3); // generates a number 0-2
    Batsman temp = new Batsman();

    // The choices of user and computer
    String compChoice = this.getMovelist().get(choice).getName();
    String userChoice = temp.getMovelist().get(shot).getName();

    System.out.println("You played a " + userChoice + " against a " + compChoice);

    // We defined certain combinations of shots and deliveries which will result in
    // OUT!
    // if the bowler could out the batsman -> we return true, else false
    if (userChoice == "Helicopter Shot" && compChoice == "Googly")
      return true;

    else if (userChoice == "Square Drive" && compChoice == "Swing")
      return true;

    else if (userChoice == "Reverse Sweep" && compChoice == "Yorker")
      return true;

    else
      return false;
  }
}

class Driver {
  public static void main(String[] args) {

    // Our players for the game :)
    Batsman user = new Batsman();
    Bowler opp = new Bowler();

    Random r = new Random();

    int TARGET = 30; // this is the target to be chased by the batsman
    int BALLS = 10; // this is the number of balls left

    System.out.println("***** Cricket 2021 World Cup *****\n");
    System.out.println("India Needs " + TARGET + " of " + BALLS + " Balls.");

    while (true) {

      if (BALLS == 0) {
        System.out.println("You Lose!");
        break;
      }

      System.out.println("\n----------------------------------------");
      System.out.println("Current Score: " + user.getRun() + " | " + BALLS + " Balls Remaining!" + "\n"
          + (TARGET - user.getRun()) + " Runs to go!");
      System.out.println("-----------------------------------------");

      BALLS--;

      try {
        // the batsman's shot is stored in userChoice
        int userChoice = user.hit();

        System.out.println();

        // if the computer could out the batsman -> OUT will be printed
        if (opp.bowl(userChoice)) {
          System.out.println("OUT!!! ;_;");
          break;
        }

      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getLocalizedMessage());
        continue;
      }

      // This line determines the runs scored by the batsman
      int runs = r.nextInt(7);

      if (runs == 6)
        System.out.println("*** SIX!!! ***");

      else if (runs == 4)
        System.out.println("*** FOUR! ***");

      else if (runs == 0)
        System.out.println("*** Missed Shot ***");
      else
        System.out.println(runs + " runs");

      // we update the runs
      user.updateRun(runs);

      if (user.getRun() >= TARGET) {
        System.out.println("VICTORY!!! :)");
        break;
      }
    }
  }
}