package br.com.ifsp.arq.exer2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumController {

    @GetMapping("/sum")
    public String sum(@RequestParam(value = "a", required = false, defaultValue = "0") int a,
                      @RequestParam(value = "b", required = false, defaultValue = "0") int b,
                      Model model) {

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a + b);

        return "sum";
    }
}
