package br.com.ifsp.arq.webfunc.persistence;

import br.com.ifsp.arq.webfunc.model.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
