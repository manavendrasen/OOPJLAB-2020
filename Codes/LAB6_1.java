import java.util.*;

interface Movable {
  // All methods in an interface are by default public abstract
  public void moveUp();

  public void moveDown();

  public void moveLeft();

  public void moveRight();
}

class MovablePoint implements Movable, Comparable<MovablePoint> {
  int x, y, xSpeed, ySpeed; // Package Private by default

  // Constructor
  public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
    this.x = x;
    this.y = y;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }

  @Override
  public String toString() {
    return ("Point at (" + x + "," + y + ")" + "xSpeed: " + xSpeed + " | ySpeed: " + ySpeed);
  }

  // Implement abstract methods defined in the interface Movable
  public void moveUp() {
    y -= ySpeed;
  }

  public void moveDown() {
    y += ySpeed;
  }

  public void moveLeft() {
    x -= xSpeed;
  }

  public void moveRight() {
    x += xSpeed;
  }

  public int compareTo(MovablePoint point) {
    if (this.x == point.x) {
      return (this.y - point.y);
    } else {
      return (this.x - point.x);
    }
  }
}

class MovableCircle implements Movable {
  // instance variables
  private MovablePoint center; // can use center.x, center.y directly because they are 1package accessible

  private int radius;

  // accessor for radius
  public int getRadius() {
    return radius;
  }

  public MovablePoint getCenter() {
    return center;
  }

  // Constructor
  public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
    // Call the MovablePoint's constructor to allocate the center
    this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    this.radius = radius;
  }

  // Implement abstract methods declared in the interface Movable
  @Override
  public void moveUp() {
    center.y -= center.ySpeed;
  }

  @Override
  public void moveDown() {
    center.y += center.ySpeed;
  }

  @Override
  public void moveLeft() {
    center.x -= center.xSpeed;
  }

  @Override
  public void moveRight() {
    center.x += center.xSpeed;
  }

  public String toString() {
    return ("Center at (" + center.x + "," + center.y + ") xSpeed: " + center.xSpeed + " | ySpeed: " + center.ySpeed
        + " | Radius: " + this.radius);
  }

}

class CompareByRadius implements Comparator<MovableCircle> {
  public int compare(MovableCircle m1, MovableCircle m2) {
    return (m1.getRadius() - m2.getRadius());
  }
}

class CompareByCenter implements Comparator<MovableCircle> {
  public int compare(MovableCircle m1, MovableCircle m2) {
    return (m1.getCenter().compareTo(m2.getCenter()));
  }
}

class CompareByRadiusCenter implements Comparator<MovableCircle> {
  public int compare(MovableCircle m1, MovableCircle m2) {
    if (m1.getRadius() == m2.getRadius())
      return (m1.getCenter().compareTo(m2.getCenter()));
    else
      return (m1.getRadius() - m2.getRadius());
  }
}

class TestMovableSecond {
  public static void main(String[] args) {

    // Making a sample point at origin
    System.out.println("Movable Point ->");
    Movable m1 = new MovablePoint(5, 6, 10, 20); // upcast
    System.out.println(m1);
    m1.moveLeft();
    System.out.println(m1);

    System.out.println("\nMovable Circle ->");
    Movable m2 = new MovableCircle(2, 1, 2, 20, 25); // upcast
    System.out.println(m2);
    m2.moveRight();
    System.out.println(m2);

  }
}