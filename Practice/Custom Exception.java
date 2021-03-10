import javax.swing.Box;

class BoxException extends RuntimeException {
  BoxException(int l) {
    System.out.println("Box Exception");
  }
}

class Cube {
  private int length;
  private int width;
  private int height;

  Cube(int l, int b, int h) {
    if (l >= 0)
      throw new BoxException(l);
    if (b >= 0)
      throw new BoxException(b);
    if (h >= 0)
      throw new BoxException(h);

    this.length = l;
    this.width = b;
    this.height = h;
  }
}

public class Exc {
  public static void main(String[] args) {
    try {
      Cube b = new Cube(0, 0, 0);

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}