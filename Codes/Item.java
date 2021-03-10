package Practicals;

public class Item {
  private String ItemName;
  private String ItemNo;
  private int ItemQuantity;
  private double ItemPrice;

  // Constructor
  Item(String ItemName, String ItemNo, int ItemQuantity, double ItemPrice) {
    this.ItemName = ItemName;
    this.ItemNo = ItemNo;
    this.ItemQuantity = ItemQuantity;
    this.ItemPrice = ItemPrice;
  }

  Item(String ItemName, String ItemNo, int ItemQuantity) {
    this.ItemName = ItemName;
    this.ItemNo = ItemNo;
    this.ItemQuantity = ItemQuantity;
    this.ItemPrice = 500;
  }

  Item(String ItemName, String ItemNo) {
    this.ItemName = ItemName;
    this.ItemNo = ItemNo;
    this.ItemQuantity = 1;
    this.ItemPrice = 500;
  }

  public String getItemName() {
    return ItemName;
  }

  public String getItemNo() {
    return ItemNo;
  }

  public double getItemPrice() {
    return ItemPrice;
  }

  public int getItemQuantity() {
    return ItemQuantity;
  }

  public void setItemName(String itemName) {
    ItemName = itemName;
  }

  public void setItemNo(String itemNo) {
    ItemNo = itemNo;
  }

  public void setItemPrice(double itemPrice) {
    ItemPrice = itemPrice;
  }

  public void setItemQuantity(int itemQuantity) {
    ItemQuantity = itemQuantity;
  }
}

class Customer {
  private String name;
  private String idNo;
  private double Balance;
  private Item item;

  Customer(String name, String idNo, double Balance) {
    this.name = name;
    this.idNo = idNo;
    this.Balance = Balance;
  }

  Customer(String name, String idNo) {
    this.name = name;
    this.idNo = idNo;
    this.Balance = 5000;
  }

  public double getBalance() {
    return Balance;
  }

  public String getIdNo() {
    return idNo;
  }

  public Item getItem() {
    return item;
  }

  public String getName() {
    return name;
  }

  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void print() {
    double price = this.item.getItemPrice();
    double quantity = this.item.getItemQuantity();
    String name = this.item.getItemName();
    String no = this.item.getItemNo();

    System.out.println("----------");
    System.out.println("Name: " + name);
    System.out.println("Price: " + price);
    System.out.println("Quantity: " + quantity);
    System.out.println("Item No.: " + no);
    System.out.println("----------");

    this.Balance = this.getBalance() - (price * quantity);
    System.out.println("Remaining Balance: " + this.Balance);
  }

  public void buyItem(Item item) {

    if (item.getItemQuantity() >= 1) {
      double totalPrice = item.getItemPrice() * item.getItemQuantity();
      if (this.getBalance() < totalPrice) {
        System.out.println("Insufficient Balance");
        return;
      }

      this.item = item;
      this.print();

    } else
      System.out.println("Order is not valid");
  }
}