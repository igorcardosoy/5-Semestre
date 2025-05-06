package br.com.ifsp.arq.webfunc.persistence;

import br.com.ifsp.arq.webfunc.model.Departamento;

import java.util.List;

public interface DepartamentoRepository {
    Departamento save(Departamento departamento);

    List<Departamento> findAll();
}
