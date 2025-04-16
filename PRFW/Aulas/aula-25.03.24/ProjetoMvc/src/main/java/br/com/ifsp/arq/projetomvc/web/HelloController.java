package br.com.ifsp.arq.projetomvc.web;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    public String hello() {
        //Algum processo
        return "Hello World!";

    }

}
