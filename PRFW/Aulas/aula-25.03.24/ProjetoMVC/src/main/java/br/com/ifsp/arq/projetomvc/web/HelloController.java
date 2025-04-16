package br.com.ifsp.arq.projetomvc.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "nome", required = false, defaultValue = "Anônimo") String user, Model model
    ) {

        model.addAttribute("nome", user);

        return "hello";
    }
}
