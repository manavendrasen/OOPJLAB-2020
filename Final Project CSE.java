import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Bayblade {
  int hp;
  String name;
  String type;
  ArrayList<Attack> attackList;

  Bayblade(String name, String type, ArrayList<Attack> attackList) {
    this.name = name;
    this.type = type;
    this.hp = 100;
    this.attackList = attackList;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public int getHp() {
    return hp;
  }

  public int Attack(int choice) {
    // we introduce a modifier to generate a random attack value
    Random rand = new Random();
    int mod = rand.nextInt(10);
    // this will return power from our Attack
    int pwr = this.attackList.get(choice).getPower();
    // this will calc the attack value pwr will be a const for a certain obj & mod
    // is random
    int attack = pwr * mod;
    if (mod == 0)
      System.out.println("\n*** Attack Dodged!! ***\n");
    else if (mod == 9)
      System.out.println("\n*** Critical Hit!! ***\n");
    else
      System.out.println(this.name + " Attacked");
    return attack;
  }

  public void TakeDamage(int attack) {
    this.hp -= attack;
    System.out.println(this.name + " Took damage" + " -" + attack);
  }

  public void showAttackList() {
    System.out.println("Choose your Attack:");
    for (int i = 0; i < this.attackList.size(); i++) {
      System.out.println((i + 1) + ". " + this.attackList.get(i).getAbtname());
    }
  }

  @Override
  public String toString() {
    return (this.name + "\n" + this.type + "\n" + this.hp + "\n" + this.attackList);
  }

}

class Attack {
  int power;
  String abtname;

  Attack(int power, String abtname) {
    this.power = power;
    this.abtname = abtname;
  }

  public int getPower() {
    return this.power;
  }

  public String getAbtname() {
    return this.abtname;
  }

  @Override
  public String toString() {
    return (this.power + " " + this.abtname);
  }
}

class Fight {
  public static void main(String[] args) {
    // creating abilities for bayblades
    Attack ThunderFury = new Attack(8, "Thunder Fury");
    Attack LeopardPunch = new Attack(4, "Leopard Punch");
    Attack AbyssFire = new Attack(6, "Abyss Fire");
    Attack CloneCannon = new Attack(5, "Clone Cannon");
    Attack DivingArrow = new Attack(5, "Diving Arrow");
    Attack EmperorCrash = new Attack(7, "Emperor Crash");
    Attack GravityBoost = new Attack(3, "Gravity Boost");
    Attack InfiniteAssault = new Attack(10, "Infinite Assault");
    Attack Strike = new Attack(1, "Strike");

    ArrayList<Attack> first = new ArrayList<Attack>();
    first.add(ThunderFury);
    first.add(AbyssFire);
    first.add(Strike);

    ArrayList<Attack> second = new ArrayList<Attack>();
    second.add(LeopardPunch);
    second.add(EmperorCrash);
    second.add(Strike);

    ArrayList<Attack> third = new ArrayList<Attack>();
    third.add(CloneCannon);
    third.add(DivingArrow);
    third.add(Strike);

    ArrayList<Attack> fourth = new ArrayList<Attack>();
    fourth.add(InfiniteAssault);
    fourth.add(GravityBoost);
    fourth.add(Strike);

    Bayblade Lld = new Bayblade("Lightning L-Drago", "Thunder", first);
    Bayblade Ee = new Bayblade("Earth Eagle", "Earth", second);
    Bayblade Fsc = new Bayblade("Flame Sagittario", "sky", third);
    Bayblade Egd = new Bayblade("Evil Gemios", "Under world", fourth);

    Bayblade arr[] = { Lld, Ee, Fsc, Egd };

    System.out.println("Choose your battle Bayblade:");
    int i = 0;
    System.out.println((++i) + ". " + Lld.getName() + " Type: " + Lld.getType());
    System.out.println((++i) + ". " + Ee.getName() + " Type: " + Ee.getType());
    System.out.println((++i) + ". " + Fsc.getName() + " Type: " + Fsc.getType());
    System.out.println((++i) + ". " + Egd.getName() + " Type: " + Egd.getType());

    Scanner sc = new Scanner(System.in);
    System.out.print("Your Choice: ");
    int user = sc.nextInt() - 1;
    int comp = (user + 2) % 4;

    System.out.println("\n*** Match Found ***\n");
    System.out.println(arr[user].getName() + " Vs " + arr[comp].getName());
    while (true) {

      System.out.println("\n----------------------------------");
      arr[user].showAttackList();

      System.out.print("Your Attack: ");

      int useratt = sc.nextInt() - 1;
      System.out.println("----------------------------------\n");
      int damage = arr[user].Attack(useratt);
      arr[comp].TakeDamage(damage);

      System.out.println("\n----------------------------------");
      System.out.println("Opponant's Turn");
      System.out.println("----------------------------------\n");
      Random rand = new Random();
      int compatt = rand.nextInt(3);
      damage = arr[comp].Attack(compatt);
      arr[user].TakeDamage(damage);

      if (arr[user].getHp() <= 0) {
        System.out.println("*** Computer Wins! :P ***");
        break;
      }
      if (arr[comp].getHp() <= 0) {
        System.out.println("*** You Win!! :) ***");
        break;
      }
      System.out.println("\n----------------------------------");
      System.out.println("User HP: " + arr[user].getHp() + " | Opponant HP: " + arr[comp].getHp());
      System.out.println("----------------------------------\n");
    }
  }

}