package br.com.ifsp.arq.paymentspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    @Qualifier("pix")
    public PaymentProcess paymentProcess;


    public void process(double amount) {
        paymentProcess.process(amount);
    }
}
