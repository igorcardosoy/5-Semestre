package edu.ifsp.ifpizza.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ifsp.ifpizza.model.Pedido;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pedido")
@SessionAttributes("pizza")
public class PedidoController {

	@GetMapping("/atual")
	public String pedidoForm(Model model) {
		log.info("Iniciando pedido");
		model.addAttribute("pedido", new Pedido());
		return "pedido-form";
	}

	@PostMapping
	public String processOrder(@Valid Pedido pedido, Errors errors) {
		if (errors.hasErrors()) {
			return "pedido-form";
		}
		
		log.info("Order submitted: " + pedido);
		return "redirect:/";
	}

}
