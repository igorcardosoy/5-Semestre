package br.com.ifsp.arq.webfunc.web;

import br.com.ifsp.arq.webfunc.model.Funcionario;
import br.com.ifsp.arq.webfunc.persistence.DepartamentoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import br.com.ifsp.arq.webfunc.persistence.FuncionarioRepository;

@Slf4j
@Controller
@RequestMapping("/")
public class CadastroFuncController {
    private final FuncionarioRepository funcRepository;
    private final DepartamentoRepository detRepository;

    public CadastroFuncController(FuncionarioRepository funcRepository, DepartamentoRepository detRepository) {
        this.funcRepository = funcRepository;
        this.detRepository = detRepository;
    }

    @ModelAttribute(name = "funcionario")
    public Funcionario funcionario(){
        return new Funcionario();
    }

    @GetMapping
    public String init() {
        return "redirect:/listar";
    }

    @GetMapping("cadastro")
    public String cadastro(Model model) {
        model.addAttribute("departamentos", detRepository.findAll());
        return "cadastro-funcionario";
    }

    @PostMapping("cadastro")
    public String cadastro(@Valid Funcionario funcionario, Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.info("Erro ao cadastrar funcionario: {}", errors.getAllErrors());
            return "redirect:/cadastro";
        }

        log.info("Cadastro do funcionario{}", funcionario);
        funcRepository.save(funcionario);

        return "redirect:/confirmacao";
    }

    @GetMapping("confirmacao")
    public String confirmacao() {
        return "confirmacao";
    }

    @GetMapping("listar")
    public String listar(Model model) {
        model.addAttribute("departamentos", detRepository.findAll());
        return "listar-funcionario";
    }

}
