package edu.ifsp.ifpizza.web;

import edu.ifsp.ifpizza.model.Ingrediente;
import edu.ifsp.ifpizza.persistence.IngredienteRepositorio;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredienteConverter implements Converter<String, Ingrediente> {
    private final IngredienteRepositorio ingredienteRepositorio;

    public IngredienteConverter(IngredienteRepositorio ingredienteRepositorio) {
        this.ingredienteRepositorio = ingredienteRepositorio;
    }

    @Override
    public Ingrediente convert(String id) {
        return ingredienteRepositorio.find(id);
    }
}
