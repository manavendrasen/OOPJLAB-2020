
import java.util.Scanner;

public class Exercise2 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int sum = 0;

    for (int i = 1; i <= 10; i++) {
      System.out.print("Enter " + i + "th digit: ");

      sum += sc.nextInt();
    }
    System.out.println("The sum is: " + sum);
  }
}