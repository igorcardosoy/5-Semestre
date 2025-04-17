package edu.ifsp.ifpizza.persistence;

import edu.ifsp.ifpizza.model.Pizza;

public interface PizzaRepositorio {
    Pizza save(Pizza pizza);
}
