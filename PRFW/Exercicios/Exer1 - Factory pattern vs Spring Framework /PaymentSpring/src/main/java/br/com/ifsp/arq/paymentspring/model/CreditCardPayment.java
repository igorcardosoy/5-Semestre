package br.com.ifsp.arq.paymentspring.model;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("credit")
public class CreditCardPayment implements PaymentProcess{

    public void process(double amount) {
        System.out.println("Credit Card Process: " + amount);
    }
}
