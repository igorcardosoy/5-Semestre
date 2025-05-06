package br.com.ifsp.arq.webfunc.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class Funcionario {
    private String id;
    private Date dataCadastro;

    @NotNull(message = "Informe ao número de matrícula, utilizando apenas números.")
    private long matricula;

    @NotBlank(message = "Informe o nome.")
    private String nome;

    @NotBlank(message = "Informe o cargo.")
    private String cargo;

    @Digits(integer = 1, fraction = 2, message = "Altura inválida. Informe um número com até duas casas decimais.")
    private Double altura;

    @NotNull(message = "Departamento não informado.")
    private long departamentoId;
}
