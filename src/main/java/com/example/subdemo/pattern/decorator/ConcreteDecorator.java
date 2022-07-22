package com.example.subdemo.pattern.decorator;

public class ConcreteDecorator extends Decorator {

  public ConcreteDecorator(Component component) {
    super(component);
  }

  @Override
  public void method() {
    //
    component.method();
    //
    concrete();
  }

  public void concrete() {
    System.out.println("concrete");
  }

}
