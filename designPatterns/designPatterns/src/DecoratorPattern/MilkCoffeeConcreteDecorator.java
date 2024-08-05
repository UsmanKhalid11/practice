package DecoratorPattern;

public class MilkCoffeeConcreteDecorator extends CoffeeDecorator{
    public MilkCoffeeConcreteDecorator(BaseComponentCoffee baseComponentCoffee) {
        super(baseComponentCoffee);
    }
    @Override
    public double cost(){
        return super.cost()+5.0;
    }
    @Override
    public String description(){
        return super.description()+" with milk";
    }
}
