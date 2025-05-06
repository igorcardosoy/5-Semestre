package br.com.ifsp.arq.webfunc.persistence;

import br.com.ifsp.arq.webfunc.model.Departamento;
import br.com.ifsp.arq.webfunc.model.Funcionario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class JdcbDepartamentoRepository implements DepartamentoRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;

    public JdcbDepartamentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("departamentos")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Departamento save(Departamento departamento) {
        long id = saveDep(departamento);
        departamento.setCodigo(id);
        return departamento;
    }

    private long saveDep(Departamento departamento) {
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", departamento.getCodigo());
        params.put("nome", departamento.getNome());
        return insert.executeAndReturnKey(params).longValue();
    }

    @Override
    public List<Departamento> findAll() {
        String sql = """
        SELECT\s
             d.id AS departamento_id
            ,d.codigo AS departamento_codigo
            ,d.nome AS departamento_nome
            ,f.id AS funcionario_id
            ,f.nome AS funcionario_nome
            ,f.matricula AS funcionario_matricula
            ,f.cargo AS funcionario_cargo
            ,f.altura AS funcionario_altura
            ,f.departamento_id AS funcionario_departamento_id
        FROM departamentos d
        LEFT JOIN funcionarios f ON d.id = f.departamento_id
   \s""";

        Map<Long, Departamento> departamentoMap = new HashMap<>();

        jdbcTemplate.query(sql, rs -> {
            long departamentoId = rs.getLong("departamento_id");
            Departamento departamento = departamentoMap.computeIfAbsent(departamentoId, id -> {
                Departamento dep = new Departamento();
                try {
                    dep.setId(rs.getLong("departamento_id"));
                    dep.setCodigo(rs.getLong("departamento_codigo"));
                    dep.setNome(rs.getString("departamento_nome"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return dep;
            });

            if (rs.getString("funcionario_id") != null) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getString("funcionario_id"));
                funcionario.setNome(rs.getString("funcionario_nome"));
                funcionario.setMatricula(rs.getLong("funcionario_matricula"));
                funcionario.setCargo(rs.getString("funcionario_cargo"));
                funcionario.setAltura(rs.getDouble("funcionario_altura"));
                funcionario.setDepartamentoId(rs.getLong("funcionario_departamento_id"));
                departamento.addFuncionario(funcionario);
            }
        });

        return new ArrayList<>(departamentoMap.values());
    }
}
