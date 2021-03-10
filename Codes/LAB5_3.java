
class A {
  public int a = 100;
} // End of class A

class B extends A {
  public int a = 80;
} // End of class B

class C extends B {
  public int a = 60;
} // End of class C

class D extends C {
  public int a = 40;
} // End of class D

class E extends D {
  public int a = 10;

  public void show() {
    int a = 0;
    System.out.println(a);
    System.out.println(this.a);
    System.out.println(super.a);
    // Question: Write Java statements to display the values of
    // all a’s used in this file on System.out

    // to access the public "a" of class A, B, C we can't use super
    // we may try to typecast the this reference ex -> (A) this.a ,
    System.out.println(((C) this).a);
    System.out.println(((B) this).a);
    System.out.println(((A) this).a);
  }
}

class Main {
  public static void main(String args[]) {
    new E().show();
    A a1 = new E();
    D d1 = (D) a1;
  }
}