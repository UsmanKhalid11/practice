package StrategyDesignPattern;

public class StrategyDesignPatternMain {

    /*
    Strategy design pattern is used so that an object can chosse different behaviour at runtime
    it consist of 3 parts
    Strategy: interface or abstract class have the definition of function of algorithm that will have
              different imple
    Concrete Strategies: Different Implementations of strategy
    Context: Has a refrence to strategy and delegates its work to strategy
    in our example
    Strategy is PaymentStrategy interface
    Concrete Strategies are PaypalPaymentStrategy and CreditCardPaymentStrategy
    Context is PaymentContext

    */
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new CreditCardPaymentStrategy("112233-000-999"));
        paymentContext.executePayment(100);
        paymentContext.setPaymentStrategy(new PaypalPaymentStrategy("abc@gmail.com"));
        paymentContext.executePayment(200);

    }

}
