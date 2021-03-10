import java.util.*;

class A {
  void print(int a) {
    System.out.println("hello from A");
  }
}

class B extends A {
  void print(int b) {
    System.out.println("hello from the other side");
  }

  int print() {
    System.out.println("overloading");
    return 0;
  }
}

class Arraylist {
  public static void main(String args[]) {
    B obj = new B();
    obj.print();
    obj.print(29);

    A obj1 = new B();
    obj1.print(22);
    obj1.print();

    A obj2 = new A();
    obj2.print(22);
    

  }
}
