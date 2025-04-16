package service;

import model.PaymentProcessor;

public class PaymentService {
    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void pay(double amount) {
        paymentProcessor.process(amount);
    }
}
