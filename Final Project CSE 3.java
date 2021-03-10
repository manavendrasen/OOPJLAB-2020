import java.util.*;
import java.io.*;
// :) 

class Employee {
  private String name;
  private int id;
  private float salary;
  private String type;
  // private Department dept;

  Employee(String name, int id, float sal) throws NameException, NumberFormatException {

    boolean hasNonAlpha = false;

    for (int i = 0; i < name.length(); i++) {
      if (!(Character.isAlphabetic(name.charAt(i)))) { // using a static method from Character
        hasNonAlpha = true;
        break;
      }
    }

    if (hasNonAlpha)
      throw new NameException("Not a valid name", name);

    this.name = name;
    this.id = id;
    this.salary = sal;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public float getSalary() {
    return salary;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  void uploadName(String name) throws NameException {
    boolean hasNonAlpha = false;
    for (int i = 0; i < name.length(); i++) {
      if (!(Character.isAlphabetic(name.charAt(i)))) { // using a static method from Character
        hasNonAlpha = true;
        break;
      }
    }

    if (hasNonAlpha)
      throw new NameException("Not a valid name", name);

    this.name = name;
  }

  public void uploadId(int id) throws NumberFormatException {
    this.id = id;
  }

  public void uploadSalary(float salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return ("ID: " + id + " Name: " + name + " Salary: " + salary);
  }
}

class Manager extends Employee {
  Manager(String name, int id, float salary) throws NameException, NumberFormatException {
    super(name, id, salary);
    this.setType("Manager");
  }

  @Override
  public String toString() {
    return (super.toString() + "\nType: " + this.getType());
  }
}

class Clerk extends Employee {
  Clerk(String name, int id, float salary) throws NameException, NumberFormatException {
    super(name, id, salary);
    this.setType("Clerk");
  }

  @Override
  public String toString() {
    return (super.toString() + "\nType: " + this.getType());
  }
}

class GDW extends Employee {
  GDW(String name, int id, float salary) throws NameException, NumberFormatException {
    super(name, id, salary);
    this.setType("GDW");
  }

  @Override
  public String toString() {
    return (super.toString() + "\nType: " + this.getType());
  }
}

class Department {
  private int ID;
  private String location;
  private ArrayList<Employee> Employees; // Each department has employees
  private String name;

  Department(int ID, String loc) {
    this.Employees = new ArrayList<Employee>();
    this.ID = ID;
    this.location = loc;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Employee> getEmployees() {
    return Employees;
  }

  public int getID() {
    return ID;
  }

  public String getLocation() {
    return location;
  }

  public void addEmployee(Employee e) {
    Employees.add(e);
  }

  public void setID(int iD) {
    ID = iD;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void showEmployees() {
    System.out.println(Employees);
  }
}

class Sales extends Department {
  Sales(int id, String loc) {
    super(id, loc);
    this.setName("Sales");
  }

}

class Market extends Department {

  Market(int id, String loc) {
    super(id, loc);
    this.setName("Market");
  }
}

class Finance extends Department {
  Finance(int id, String loc) {
    super(id, loc);
    this.setName("Finance");
  }
}

class Driver {
  public static void main(String[] args) throws IOException {
    Sales salesDept = new Sales(10, "Delhi");
    Market marketDept = new Market(20, "Kolkata");
    Finance financeDept = new Finance(30, "Chennai");

    try {
      File f1 = new File("employee.txt"); // Creation of File Descriptor for input file
      String[] words = null; // Intialize the word Array
      FileReader fr = null;
      String s;
      BufferedReader br = null; // Creation of BufferedReader object
      try {
        fr = new FileReader(f1);
        br = new BufferedReader(fr);
      } catch (FileNotFoundException fe) {
        System.out.println("File not found");
      }
      while ((s = br.readLine()) != null) // Reading Content from the file
      {
        words = s.split(" "); // Split the word using space
      }
      fr.close();

      Employee e1 = new Employee(words[0], 1, 2000.0f);
      Employee e2 = new Employee(words[1], 2, 3000.0f);
      Employee e3 = new Employee(words[2], 3, 4000.0f);
      Employee e4 = new Employee(words[3], 4, 9000.0f);
      salesDept.addEmployee(e1);
      salesDept.addEmployee(e2);
      marketDept.addEmployee(e3);
      financeDept.addEmployee(e4);

      System.out.println("Details of Employees: ");
      System.out.println(e1);
      System.out.println(e2);
      System.out.println(e3);
      System.out.println(e4);

      System.out.println("Employees of Sales Dept: ");
      salesDept.showEmployees();

      System.out.println("\nEmployees of Market Dept: ");
      marketDept.showEmployees();

      System.out.println("\nEmployees of Finance Dept: ");
      financeDept.showEmployees();

    } catch (

    NumberFormatException e) {
      System.out.println(e.getMessage());
    } catch (NameException e) {
      System.out.println(e.getMessage());
    }

  }
}

// EXCEPTIONS
class NameException extends Exception {
  String invalidName;

  NameException(String errorMessage, String invalidName) {
    super(errorMessage);
    this.invalidName = invalidName;
    System.out.println("Name Exception: " + invalidName + " is not a valid name");

  }
}