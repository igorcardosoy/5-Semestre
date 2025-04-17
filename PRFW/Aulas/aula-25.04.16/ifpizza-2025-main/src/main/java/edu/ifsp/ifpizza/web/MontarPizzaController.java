package edu.ifsp.ifpizza.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.ifsp.ifpizza.model.Pedido;
import edu.ifsp.ifpizza.persistence.IngredienteRepositorio;
import edu.ifsp.ifpizza.persistence.PizzaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import edu.ifsp.ifpizza.model.Ingrediente;
import edu.ifsp.ifpizza.model.Ingrediente.Tipo;
import edu.ifsp.ifpizza.model.Pizza;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/montarpizza")
@SessionAttributes("pedido")
public class MontarPizzaController {
	private final IngredienteRepositorio ingredienteRepositorio;
	private final PizzaRepositorio pizzaRepositorio;

    public MontarPizzaController(IngredienteRepositorio ingredienteRepositorio, PizzaRepositorio pizzaRepositorio) {
        this.ingredienteRepositorio = ingredienteRepositorio;
		this.pizzaRepositorio = pizzaRepositorio;
    }

	@ModelAttribute(name = "pedido")
	public Pedido pedido(){
		return new Pedido();
	}

	@ModelAttribute(name = "pizza")
	public Pizza pizza(){
		return new Pizza();
	}

	@GetMapping
	public String iniciar(Model model) {
		List<Ingrediente> ingredientes = new LinkedList<>();
		ingredienteRepositorio.findAll().forEach(ingredientes::add);
		
		for (Tipo tipo : Tipo.values()) {
			List<Ingrediente> agrupados = agrupar(ingredientes, tipo);
			String categoria = tipo.toString().toLowerCase();
			model.addAttribute(categoria, agrupados);
		}
		
		return "design";
	}


	private List<Ingrediente> agrupar(List<Ingrediente> ingredientes, Tipo tipo) {
		List<Ingrediente> agrupados = new ArrayList<>();
		
		for (Ingrediente ingrediente: ingredientes) {
			if (ingrediente.getTipo() == tipo) {
				agrupados.add(ingrediente);
			}
		}
		
		return agrupados;
	}
	
	
	@PostMapping
	public String processar(@Valid Pizza pizza, Errors errors, @ModelAttribute Pedido pedido) {
		if (errors.hasErrors()) {
			log.info("Pizza contém erros de validação.");
			return "design";
		}
        log.info("Processando pizza: {}", pizza);

		pizzaRepositorio.save(pizza);
		pedido.add(pizza);
		
		return "redirect:/pedido/atual";
	}
}







