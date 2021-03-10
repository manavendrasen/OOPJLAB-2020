import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Account {
  private long acctNumber;
  private double balance;
  private String name;

  /*
   * Complete the Account class by adding proper constructor,accessor method and
   * mutator method as required.Override toSring() method to display account
   * details.
   */
  Account(long acc, double balance, String name) {
    this.acctNumber = acc;
    this.balance = balance;
    this.name = name;
  }

  public long getAcctNumber() {
    return acctNumber;
  }

  public double getBalance() {
    return balance;
  }

  public String getName() {
    return name;
  }

  public void setAcctNumber(long acctNumber) {
    this.acctNumber = acctNumber;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return ("Name: " + name + "\n" + "Account No.: " + acctNumber + "\n" + "Balance: " + balance);
  }
}

class Bank {
  private ArrayList<Account> accts;
  static int maxActive = 30;
  static int currentNumber = 0;

  Bank() {
    accts = new ArrayList<Account>();
  }

  public boolean addAccount(Account newone) {
    /*
     * Write the code for adding new account, return false if account can’t be
     * created
     */
    if (currentNumber > maxActive) {
      System.out.println("At full capacity");
      return false;
    }

    if (accts.indexOf(newone) != -1)
      return false;

    accts.add(newone);
    currentNumber++;
    return true;
  }

  public boolean removeAccount(long acctnum) {
    /*
     * Write the code for removing the account, return false if account does not
     * exist
     */
    Iterator itr = accts.iterator();
    int flag = 0;
    while (itr.hasNext()) {
      Account current = (Account) itr.next();
      if (current.getAcctNumber() == acctnum) {
        flag++;
        itr.remove();
        currentNumber--;
        break;
      }
    }
    if (flag == 0)
      return false;

    return true;
  }

  public double deposit(long acctnum, double amount) {
    /*
     * Write the code for depositing specified amount to the account, return -1 if
     * account does not exist
     */
    double res = -1;
    Iterator itr = accts.iterator();
    while (itr.hasNext()) {
      Account current = (Account) itr.next();
      if (current.getAcctNumber() == acctnum) {
        res = current.getBalance() + amount;
        current.setBalance(res);
        break;
      }
    }
    return res;
  }

  public double withdraw(long acctnum, double amount) {
    /*
     * Write the code for withdrawing specified amount from the account, return -1
     * if insufficient balance or account does not exist
     */
    double res = -1;
    Iterator itr = accts.iterator();
    while (itr.hasNext()) {
      Account current = (Account) itr.next();
      if (current.getAcctNumber() == acctnum) {
        if (current.getBalance() < amount) {
          System.out.println("Insufficient Balance!");
          break;
        }
        res = current.getBalance() - amount;
        current.setBalance(res);
        break;
      }
    }
    return res;
  }

  // override toString() method to display details of all the accounts in bank
  @Override
  public String toString() {
    String res = "";
    Iterator itr = accts.iterator();
    while (itr.hasNext()) {
      Account current = (Account) itr.next();
      res += (current.toString() + "\n\n");
    }
    return res;
  }
}

class Driver {
  public static void main(String[] args) {
    Bank LnL = new Bank();

    Account a1 = new Account(199302058, 20000.0, "Manavendra Sen");
    Account a2 = new Account(189232320, 20000.0, "Rahul Sharma");
    Account a3 = new Account(109378288, 80000.0, "Alok Kumar");

    LnL.addAccount(a1);
    LnL.addAccount(a2);
    LnL.addAccount(a3);
    System.out.println("Added 3 accounts: \n" + LnL);
    LnL.removeAccount(189232320);
    System.out.println("Removed one account: \n" + LnL);

    LnL.deposit(199303058, 100000.0);
    System.out.println("After Deposit: \n" + LnL);

    LnL.withdraw(199302058, 120000.0);
    System.out.println("After Withdraw: \n" + LnL);
  }
}