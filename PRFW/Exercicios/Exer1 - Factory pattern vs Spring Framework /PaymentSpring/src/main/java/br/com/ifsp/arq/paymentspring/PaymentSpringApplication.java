package br.com.ifsp.arq.paymentspring;

import br.com.ifsp.arq.paymentspring.model.PaymentProcess;
import br.com.ifsp.arq.paymentspring.model.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentSpringApplication implements CommandLineRunner {

    @Autowired
    private PaymentService paymentService;

    public static void main(String[] args) {
        SpringApplication.run(PaymentSpringApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        paymentService.process(10);
    }
}
