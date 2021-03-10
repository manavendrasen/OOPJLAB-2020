
abstract class Worker {
  private String name;
  private double salary_rate;

  Worker(String name, double salary_rate) {
    this.name = name;
    this.salary_rate = salary_rate;
  }

  public abstract double computePay();

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

}

class FullTimeWorker extends Worker {
  private int hoursWorked;

  FullTimeWorker(String name, double salary_rate, int hoursWorked) {
    super(name, salary_rate);
    this.hoursWorked = hoursWorked;
  }

  public int getHoursWorked() {
    return hoursWorked;
  }

  public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double computePay() {
    if (this.getHoursWorked() < 240) {
      return this.getHoursWorked() * 100.00;
    }
    return 240 * 100.00;
  }
}

class HourlyWorker extends Worker {
  int hoursWorked;

  public int getHoursWorked() {
    return hoursWorked;
  }

  public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double computePay() {
    if (this.getHoursWorked() < 60) {
      return this.getHoursWorked() * 50.00;
    }
    return 60 * 50.00;
  }

  HourlyWorker(String name, double salary_rate, int hoursWorked) {
    super(name, salary_rate);
    this.hoursWorked = hoursWorked;
  }
}

class TestWorker {

}