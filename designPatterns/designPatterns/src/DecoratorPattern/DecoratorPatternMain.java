package DecoratorPattern;

public class DecoratorPatternMain {
    public static void main(String[] args) {
/*
    Decorator design patter is structural design pattern follows open to extenstion and close
    to modification principle and extends functionality of object at runtime
    has 4 parts
    Component:Interface or abstract class of base behaviour (BaseComponentCoffee here)
    Concrete class:implementation of base behaviour (BaseConcreteCoffeeImpl here)
    Decorator: implements component and have refrence to concrete class.(CoffeeDecorator here)
    Concrete Decorator: extends decorator and provide extension of functionality to base behaviour (MilkCoffeeConcreteDecorator & SugerCoffeeConcreteDecorator here )

  */
        System.out.println("Base behaviour");
        BaseComponentCoffee mycoffee= new BaseConcreteCoffeeImpl();
        System.out.println(mycoffee.description()+"  price:"+mycoffee.cost());
        System.out.println("Adding milk");
        mycoffee= new MilkCoffeeConcreteDecorator(mycoffee);
        System.out.println(mycoffee.description()+"  price:"+mycoffee.cost());
        System.out.println("Adding Sugar");
        mycoffee= new SugerCoffeeConcreteDecorator(mycoffee);
        System.out.println(mycoffee.description()+"  price:"+mycoffee.cost());

    }
    /*
    Base behaviour
    base coffee  price:5.0
    Adding milk
    base coffee with milk  price:10.0
    Adding Sugar
    base coffee with milk with sugar  price:10.5
    functionalit is added to our object through decorator design pattern
    */
}
