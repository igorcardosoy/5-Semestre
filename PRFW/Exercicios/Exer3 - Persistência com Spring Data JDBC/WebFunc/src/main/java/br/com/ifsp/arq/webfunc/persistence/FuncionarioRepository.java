package br.com.ifsp.arq.webfunc.persistence;

import br.com.ifsp.arq.webfunc.model.Funcionario;

import java.util.List;

public interface FuncionarioRepository {
    Funcionario save(Funcionario funcionario);

    Funcionario findById(String id);

    List<Funcionario> findByDepartamento(String departamentoId);

    List<Funcionario> findAll();
}
