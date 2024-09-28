package StrategyDesignPattern;

public class PaypalPaymentStrategy implements PaymentStrategy{

    public String email;
    public PaypalPaymentStrategy(String email){
        this.email=email;
    }
    @Override
    public void pay(int amount) {
        System.out.println("Paid by paypal amount "+amount+" and email "+email);
    }
}
