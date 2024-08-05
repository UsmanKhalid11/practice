package DecoratorPattern;

public class CoffeeDecorator implements BaseComponentCoffee{
    private BaseComponentCoffee baseComponentCoffee;
    public CoffeeDecorator(BaseComponentCoffee baseComponentCoffee){
        this.baseComponentCoffee=baseComponentCoffee;

    }


    @Override
    public double cost() {
        return baseComponentCoffee.cost();
    }

    @Override
    public String description() {
        return baseComponentCoffee.description();
    }
}
