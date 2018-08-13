package main.java.inheritance;

public class BaseClassConstructor extends Child1 {
  public BaseClassConstructor() {
    System.out.println("Base called");
  }

  public static void main(String[] args) {
    new BaseClassConstructor();
  }
}


class Child1 {
  public Child1() {
    System.out.println("Child1");
  }
}
