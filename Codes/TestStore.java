package Practicals;

import java.util.Scanner;

class Test {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Customer Name: ");
    String name = sc.nextLine();
    System.out.print("Enter Customer ID: ");
    String id = sc.nextLine();
    System.out.print("Enter Balance: ");
    double balance = sc.nextDouble();

    Customer c1 = new Customer(name, id, balance);

    // input for item
    System.out.println("Enter Item Details: ");
    System.out.print("-- Enter Product Name: ");
    String itemName = sc.next();
    System.out.print("-- Enter Item ID: ");
    String itemID = sc.next();
    System.out.print("-- Enter Quantity: ");
    int itemQuantity = sc.nextInt();
    System.out.print("-- Enter Price: ");
    double itemPrice = sc.nextDouble();

    Item item1 = new Item(itemName, itemID, itemQuantity, itemPrice);
    c1.buyItem(item1);

    System.out.println("\nEnter Item Details: ");
    System.out.print("-- Enter Product Name: ");
    String itemName2 = sc.next();
    System.out.print("-- Enter Item ID: ");
    String itemID2 = sc.next();
    System.out.print("-- Enter Quantity: ");
    int itemQuantity2 = sc.nextInt();
    System.out.print("-- Enter Price: ");
    double itemPrice2 = sc.nextDouble();

    Item item2 = new Item(itemName2, itemID2, itemQuantity2, itemPrice2);
    c1.buyItem(item2);
  }
}
