package br.com.ifsp.arq.webfunc.persistence;

import br.com.ifsp.arq.webfunc.model.Departamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
}
