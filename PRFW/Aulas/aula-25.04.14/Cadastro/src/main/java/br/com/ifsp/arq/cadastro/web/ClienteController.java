package br.com.ifsp.arq.cadastro.web;


import br.com.ifsp.arq.cadastro.cliente.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClienteController {

    @GetMapping("/exibir")
    public String exibir(Model model){
        Cliente cliente = new Cliente("Igor", "igor@gmail.com", false);

        model.addAttribute("cliente", cliente);

        return "cliente";
    }

    @GetMapping("/listar")
    public String listar(Model model) {

        List<Cliente> allClients = List.of(
                new Cliente("Caio", "caio@gmail.com", false),
                new Cliente("Augusto", "augusto@gmail.com", true),
                new Cliente("Joao", "joao@gmail.com", false)
        );

        model.addAttribute("clientes", allClients);

        return "lista";
    }

}
