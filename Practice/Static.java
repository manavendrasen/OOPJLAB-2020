class Apple {
  private int weight = 30;
  private String quality;

  public static int a;
  public static int b;

  Apple() {
    this.weight = 10;
    this.quality = "Premium";
    a = 100;
    b = 200;
  }

  Apple(int w) {
    this.Apple();
    this.weight = w;
  }

  public String toString() {
    return "hello";
  }
}

class testclass{
  public static void main(String args[]) {
    Apple a1 = new Apple();
    Apple a2 = new Apple();
    System.out.println(Apple.a);
    System.out.println(Apple.a);

  }
}
