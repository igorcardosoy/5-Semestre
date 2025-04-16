package model;

public class PayPalPayment implements PaymentProcessor{


    @Override
    public void process(double amount) {
        System.out.println("PayPal Payment");
    }
}
