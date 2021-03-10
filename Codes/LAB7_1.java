class Circle {
  private int rad;

  public Circle(int radius) {
    rad = radius;
  }

  public double area() {
    return Math.PI * rad * rad;
  }
}

class Anonymous {
  public Circle getCircle(int radius) {
    return new Circle(radius);
  }

  public static void main(String[] args) {
    Anonymous p = new Anonymous();
    Circle w = p.getCircle(10);
    // The output here should give correct value of area
    // of the circle.
    System.out.println(w.area());
  }
}
