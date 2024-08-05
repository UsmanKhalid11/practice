package DecoratorPattern;

public class BaseConcreteCoffeeImpl implements BaseComponentCoffee{
    @Override
    public double cost() {
        return 5.0;
    }

    @Override
    public String description() {
        return "base coffee";
    }
}
