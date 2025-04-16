package br.com.ifsp.arq.paymentspring.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pix")
public class PixPayment implements PaymentProcess {

    public void process(double amount) {
        System.out.println("PixPayment Process: " + amount);
    }
}
