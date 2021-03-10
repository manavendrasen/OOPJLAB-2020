package Practicals;

import java.util.Scanner;

public class TaxOnSalary {
  private double salary;
  private boolean isPANsubmitted;

  Scanner sc = new Scanner(System.in);

  TaxOnSalary() {
    salary = 0.0;
    isPANsubmitted = false;
  }

  TaxOnSalary(boolean pan) {
    salary = 1000.0;
    isPANsubmitted = pan;
  }

  public double getSalary() {
    return salary;
  }

  public boolean getIsPANsubmitted() {
    return isPANsubmitted;
  }

  public double calculateTax() {
    double tax;
    if (salary <= 180000 && isPANsubmitted == true) {
      tax = 0;
    } else if (salary <= 180000 && isPANsubmitted == false) {
      tax = 0.05 * salary;
    } else if (salary > 180000 && salary <= 500000) {
      tax = 0.1 * salary;
    } else if (salary > 500000 && salary <= 1000000) {
      tax = 0.2 * salary;
    } else {
      tax = 0.3 * salary;
    }
    return tax;
  }

  public double inputSalary() {
    System.out.print("Enter the salary: ");
    this.salary = sc.nextDouble();
    return this.salary;
  }

}

class TestTax {
  public static void main(String args[]) {
    TaxOnSalary tax1 = new TaxOnSalary();
    tax1.inputSalary();
    System.out.println("Tax: " + tax1.calculateTax());

    TaxOnSalary tax2 = new TaxOnSalary(true);
    tax2.inputSalary();
    System.out.println("Tax: " + tax2.calculateTax());
  }
}