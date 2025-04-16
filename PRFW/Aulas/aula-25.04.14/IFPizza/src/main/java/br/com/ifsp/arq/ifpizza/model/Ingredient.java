package br.com.ifsp.arq.ifpizza.model;

import lombok.Data;

@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        CRUST, PROTEIN, VEGETABLES, CHEESE, SAUCE
    }
}