
class Employee {
  private String name;
  private double salary;

  // Parameterized constructor
  Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  // Overriding the toString method of object class
  @Override
  public String toString() {
    return ("Employee Name: " + this.getName() + "\n" + "Salary: " + this.getSalary());
  }
}

// Subclass

class Manager extends Employee {
  private String department;

  Manager(String name, double salary, String department) {
    // Every time an object of a subclass will be created we need the values from
    // its super/parent class also, so we call the super method
    super(name, salary);
    this.department = department;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  @Override
  public String toString() {
    // We call the to string method of its super and concatenate to it
    return super.toString() + "\n" + "Department: " + this.getDepartment();
  }
}

class Driver {
  public static void main(String[] args) {
    Employee e1 = new Employee("Felix", 20000.0);
    Employee e2 = new Employee("Mark", 18000.0);

    Manager m1 = new Manager("Sean", 50000.0, "Video Production");
    Manager m2 = new Manager("Patrick", 25000.0, "Security");

    // Displaying the details in the console
    System.out.println("-- Employee Details --");
    System.out.println(e1 + "\n");
    System.out.println(e2 + "\n");
    System.out.println(m1 + "\n");
    System.out.println(m2 + "\n");
  }
}