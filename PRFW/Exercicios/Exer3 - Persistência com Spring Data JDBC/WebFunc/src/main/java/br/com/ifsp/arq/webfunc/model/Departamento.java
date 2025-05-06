package br.com.ifsp.arq.webfunc.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Data
public class Departamento {
    private long id;
    private long codigo;
    private String nome;

    @Setter(AccessLevel.NONE)
    List<Funcionario> funcionarios = new LinkedList<>();

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return new LinkedList<>(funcionarios);
    }
}
