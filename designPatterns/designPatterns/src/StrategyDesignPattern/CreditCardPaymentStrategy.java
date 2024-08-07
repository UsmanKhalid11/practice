package StrategyDesignPattern;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    public String ccNo;
    public CreditCardPaymentStrategy( String ccNo){
        this.ccNo=ccNo;
    }
    @Override
    public void pay(int amount) {
        System.out.println("Paid through credit card amount "+amount+" and credit card no "+ccNo);
    }
}
