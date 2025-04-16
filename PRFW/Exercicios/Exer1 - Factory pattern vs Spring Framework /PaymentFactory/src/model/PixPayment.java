package model;

public class PixPayment implements PaymentProcessor {


    @Override
    public void process(double amount) {
        System.out.println("PixPayment processed " + amount);
    }
}
