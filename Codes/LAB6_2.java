import java.util.*;

interface BinaryInterface {
  public void toBinary(int n);
}

class SignedMagnitude implements BinaryInterface {
  ArrayList<Integer> a = new ArrayList<Integer>();
  int temp;

  public void toBinary(int x) {
    int n = Math.abs(x);
    if (x < 0) {
      a.add(1);
    } else {
      a.add(0);
    }
    while (n != 0) {
      temp = n % 2;
      a.add(1, temp);
      n = n / 2;
    }
    int k = a.size();
    for (int i = 0; i < (8 - k); i++) {
      a.add(1, 0);
    }
    System.out.println(a);
  }
}

class OneComplement implements BinaryInterface {
  ArrayList<Integer> a = new ArrayList<Integer>();
  int temp;

  public void toBinary(int x) {
    int n = Math.abs(x);
    while (n != 0) {
      temp = n % 2;
      a.add(0, temp);
      n = n / 2;
    }
    int k = a.size();
    for (int i = 0; i < (8 - k); i++) {
      a.add(0, 0);
    }
    for (int z = 0; z < a.size(); z++) {
      if (a.get(z) == 0) {
        a.set(z, 1);
      } else {
        a.set(z, 0);
      }
    }
    System.out.println(a);
  }
}

class TwoComplement implements BinaryInterface {
  ArrayList<Integer> a = new ArrayList<Integer>();
  int temp;

  public void toBinary(int x) {
    int n = Math.abs(x);
    while (n != 0) {
      temp = n % 2;
      a.add(0, temp);
      n = n / 2;
    }
    int k = a.size();
    for (int i = 0; i < (8 - k); i++) {
      a.add(0, 0);
    }
    int flag = 0;
    for (int i = a.size() - 1; i >= 0; i--) {
      if (flag == 1) {
        if (a.get(i) == 0) {
          a.set(i, 1);
        } else {
          a.set(i, 0);
        }
      }
      if (a.get(i) == 1) {
        flag = 1;
      }
    }
    System.out.println(a);
  }
}

class BinaryTest {
  public static void main(String args[]) {

    OneComplement num2 = new OneComplement();
    System.out.print("One's Complement of -20 is ");
    num2.toBinary(-20);

    TwoComplement num3 = new TwoComplement();
    System.out.print("Two's Complement of -20 is ");
    num3.toBinary(-20);

    SignedMagnitude num1 = new SignedMagnitude();
    System.out.print("Sign Magnitude of -20 is ");
    num1.toBinary(-20);

  }
}