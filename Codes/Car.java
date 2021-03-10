package Practicals;

public class Car {
  private int year;
  private String make;
  private double speed;

  Car(int year, String make, double speed) {
    this.year = year;
    this.make = make;
    this.speed = speed;
  }

  public String getMake() {
    return make;
  }

  public double getSpeed() {
    return speed;
  }

  public int getYear() {
    return year;
  }

  public void Accelerate() {
    this.speed++;
  }

  public void Accelerate(int increment) {
    this.speed += increment;
  }

  public void Brake(int b) {
    this.speed -= Math.sqrt(b);
  }
}

class RaceTrack {

  public static void main(String[] args) {
    Car newCar = new Car(2020, "Honda", 30.0);
    System.out.println("Year: " + newCar.getYear());
    System.out.println("Make: " + newCar.getMake());
    System.out.println("Speed: " + newCar.getSpeed());

    newCar.Accelerate();
    System.out.println("Speed: " + newCar.getSpeed());
    newCar.Accelerate(10);
    System.out.println("Speed: " + newCar.getSpeed());

    newCar.Brake(25);
    System.out.println("Speed: " + newCar.getSpeed());

    // Car car2 = new Car();
  }

}