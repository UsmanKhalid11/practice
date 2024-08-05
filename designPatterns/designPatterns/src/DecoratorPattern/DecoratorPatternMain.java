package DecoratorPattern;

public class DecoratorPatternMain {
    public static void main(String[] args) {
/*
    Decorator design patter is structural design pattern follows open to extenstion and close
    to modification principle
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
}
