
import java.io.*;

public class Exercise1 {
  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    int sum = 0;

    for (int i = 1; i <= 10; i++) {
      System.out.print("Enter " + i + "th digit: ");
      sum += Integer.parseInt(br.readLine());

    }
    System.out.println("The sum is: " + sum);
  }
}