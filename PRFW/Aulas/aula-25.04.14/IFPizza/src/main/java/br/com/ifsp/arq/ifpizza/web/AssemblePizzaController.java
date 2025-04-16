package br.com.ifsp.arq.ifpizza.web;

import br.com.ifsp.arq.ifpizza.model.Ingredient;
import br.com.ifsp.arq.ifpizza.model.Ingredient.Type;
import br.com.ifsp.arq.ifpizza.model.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("assemble-pizza")
public class AssemblePizzaController {

    @GetMapping
    public String init(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("CTPY", "Catupiry", Type.CRUST),
                new Ingredient("SMPL", "Simples", Type.CRUST),
                new Ingredient("PRST", "Presunto", Type.PROTEIN),
                new Ingredient("CARN", "Carne", Type.PROTEIN),
                new Ingredient("TMTE", "Tomate", Type.VEGETABLES),
                new Ingredient("RCLA", "Rúcula", Type.VEGETABLES),
                new Ingredient("MSRL", "Mussarela", Type.CHEESE),
                new Ingredient("PROV", "Provolone", Type.CHEESE)
        );

        for (Type type : Type.values()) {
            List<Ingredient> groupedIngredients = groupIngredients(ingredients, type);

            String category = type.toString().toLowerCase();
            model.addAttribute(category, groupedIngredients);
        }

        model.addAttribute("pizza", new Pizza());

        return "design";
    }

    private List<Ingredient> groupIngredients(List<Ingredient> ingredients, Type type) {
        List<Ingredient> groupedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getType().equals(type)) {
                groupedIngredients.add(ingredient);
            }
        }

        return groupedIngredients;
    }

    @PostMapping
    public String process(Pizza pizza) {
        log.info("Processing pizza: {}", pizza);

        // return "redirect:/pedidos/atual";
        return "redirect:/assemble-pizza";
    }
}
