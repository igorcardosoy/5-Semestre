package br.com.ifsp.arq.webfunc.model;

import lombok.Data;

@Data
public class Funcionario {

    private long matricula;
    private String nome;
    private String cargo;
    private Double altura;
}
