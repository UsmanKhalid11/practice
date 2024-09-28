package StrategyDesignPattern;

public class PaymentContext {

    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(int amount){
        paymentStrategy.pay(amount);
    }
}
