class Circle {
  // static final means this is a class attribute and its value can't be changed
  static final double PI = 3.14;
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  // accessor method
  public double getRadius() {
    return radius;
  }

  // mutator method
  public void setRadius(double radius) {
    this.radius = radius;
  }

  // method to find the area
  public static double area(Circle c1) {
    // Static reference to PI
    return (PI * c1.getRadius() * c1.getRadius());
  }

  // static method's are not instance specific
  public static void getCircumference(double radius) {
    // here radius variable is a local variable
    System.out.println("Circumference = " + 2 * PI * radius);
  }
}// End of circle

class TestCircle {
  public static void main(String args[]) {
    Circle c1 = new Circle(2.3);
    Circle.area(c1);

    // accessing static method with class name
    Circle.getCircumference(2.3);
    Circle c2 = new Circle(3.45);
    Circle.area(c2);

    // accessing static method with references is discouraged
    // c1.getCircumference(3.45); // this will work with warnings, static methods
    // should be referenced static
    Circle.getCircumference(3.45);
  } // end of main
} // end of class
