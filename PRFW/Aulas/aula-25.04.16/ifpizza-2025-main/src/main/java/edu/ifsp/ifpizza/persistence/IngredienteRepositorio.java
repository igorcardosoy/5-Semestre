package edu.ifsp.ifpizza.persistence;

import edu.ifsp.ifpizza.model.Ingrediente;

public interface IngredienteRepositorio {
    Iterable<Ingrediente> findAll();
    Ingrediente find(String id);
    Ingrediente save(Ingrediente ingrediente);
}
