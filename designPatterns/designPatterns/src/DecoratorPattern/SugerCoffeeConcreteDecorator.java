package DecoratorPattern;

public class SugerCoffeeConcreteDecorator extends CoffeeDecorator{
    public SugerCoffeeConcreteDecorator(BaseComponentCoffee baseComponentCoffee) {
        super(baseComponentCoffee);
    }
    @Override
    public double cost(){
        return super.cost()+0.5;
    }
    @Override
    public String description(){
        return super.description()+" with sugar";
    }
}