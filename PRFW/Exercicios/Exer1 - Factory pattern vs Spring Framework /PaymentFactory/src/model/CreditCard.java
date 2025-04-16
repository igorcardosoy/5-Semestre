package model;

public class CreditCard implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Credit Card Payment");
    }
}
