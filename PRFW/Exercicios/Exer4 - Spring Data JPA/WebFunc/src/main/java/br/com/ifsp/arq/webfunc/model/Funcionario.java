package br.com.ifsp.arq.webfunc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @NotNull(message = "Informe ao número de matrícula, utilizando apenas números.")
    private long matricula;

    @NotBlank(message = "Informe o nome.")
    private String nome;

    @NotBlank(message = "Informe o cargo.")
    private String cargo;

    @NotNull(message = "Informe a altura.")
    @Digits(integer = 1, fraction = 2, message = "Altura inválida. Informe um número com até duas casas decimais.")
    @Column(precision = 3, scale = 2)
    private BigDecimal altura;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Date();
    }
}
