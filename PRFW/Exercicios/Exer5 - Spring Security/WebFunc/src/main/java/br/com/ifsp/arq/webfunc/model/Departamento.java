package br.com.ifsp.arq.webfunc.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString(exclude = "funcionarios")
@Entity
@Table(name = "departamentos")
public class Departamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long codigo;

    private String nome;



    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private List<Funcionario> funcionarios = new LinkedList<>();

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return new LinkedList<>(funcionarios);
    }
}
