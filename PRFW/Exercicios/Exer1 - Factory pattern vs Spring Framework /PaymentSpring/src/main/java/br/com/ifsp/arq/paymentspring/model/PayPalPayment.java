package br.com.ifsp.arq.paymentspring.model;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("paypal")
public class PayPalPayment implements PaymentProcess{

    public void process(double amount) {
        System.out.println("PayPal Process: " + amount);
    }
}
