package edu.ifsp.ifpizza.persistence;

import edu.ifsp.ifpizza.model.Ingrediente;
import edu.ifsp.ifpizza.model.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcPizzaRepositorio implements PizzaRepositorio {
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert pizzaInserter;

    public JdbcPizzaRepositorio(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.pizzaInserter = new SimpleJdbcInsert(this.jdbc)
                .withTableName("pizza")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Pizza save(Pizza pizza) {
        pizza.setDataCriacao(new Date());

        Long id = savePizza(pizza);
        pizza.setId(id);

        for (Ingrediente ingrediente : pizza.getIngredientes()) {
            saveIngrediente(ingrediente, pizza);
        }

        return pizza;
    }

    private Long savePizza(Pizza pizza) {
        Map<String, Object> values = new HashMap<>();
        values.put("nome", pizza.getNome());
        values.put("data_criacao", pizza.getDataCriacao());
        Long id = pizzaInserter.executeAndReturnKey(values).longValue();
        return id;
    }

    private void saveIngrediente(Ingrediente ingrediente, Pizza pizza) {
        jdbc.update(
                "insert into pizza_ingrediente (pizza_id, ingrediente_id) values (?, ?)",
                pizza.getId(), ingrediente.getId()
        );
    }


}
