package br.com.ifsp.arq.webfunc.web;

import br.com.ifsp.arq.webfunc.model.Funcionario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/")
@SessionAttributes("dados")
public class CadastroFuncController {

    @GetMapping
    public String init() {
        return "redirect:/cadastro";
    }

    @GetMapping("cadastro")
    public String cadastro(Model model) {
        if (!model.containsAttribute("dados")) {
            model.addAttribute("dados", new ArrayList<Funcionario>(1));
        }
        model.addAttribute("funcionario", new Funcionario());
        return "cadastro-funcionario";
    }

    @PostMapping("cadastro")
    public String cadastro(Funcionario funcionario, Model model) {
        log.info("Cadastro do funcionario{}", funcionario);

        ArrayList<Funcionario> dados = (ArrayList<Funcionario>) model.getAttribute("dados");
        dados.add(funcionario);
        model.addAttribute("dados", dados);

        return "redirect:/confirmacao";
    }

    @GetMapping("confirmacao")
    public String confirmacao(Funcionario funcionario, Model model) {
        model.addAttribute("funcionario",
                ((ArrayList<Funcionario>) model.getAttribute("dados")).getLast());
        return "confirmacao";
    }

    @GetMapping("listar")
    public String listar() {
        return "listar-funcionario";
    }

}
