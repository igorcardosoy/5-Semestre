package br.com.ifsp.arq.webfunc.persistence;

import br.com.ifsp.arq.webfunc.model.Funcionario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcFuncionarioRepository implements FuncionarioRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert funcionarioInserter;


    public JdbcFuncionarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.funcionarioInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("funcionarios")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        funcionario.setDataCadastro(new Date());

        long id = saveFunc(funcionario);
        funcionario.setId(String.valueOf(id));
        return funcionario;
    }

    private long saveFunc(Funcionario funcionario) {
        Map<String, Object> values = new HashMap<>();
        values.put("nome", funcionario.getNome());
        values.put("data_cadastro", funcionario.getDataCadastro());
        values.put("matricula", funcionario.getMatricula());
        values.put("cargo", funcionario.getCargo());
        values.put("altura", funcionario.getAltura());
        values.put("departamento_id", funcionario.getDepartamentoId());

        return funcionarioInserter.executeAndReturnKey(values).longValue();
    }

    private Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getString("id"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setMatricula(rs.getLong("matricula"));
        funcionario.setCargo(rs.getString("cargo"));
        funcionario.setAltura(rs.getDouble("altura"));
        funcionario.setDepartamentoId(rs.getLong("departamento_id"));
        return funcionario;
    }

    @Override
    public Funcionario findById(String id) {
        String sql = "SELECT id, nome, matricula, cargo, altura, departamento_id FROM funcionarios WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    @Override
    public List<Funcionario> findByDepartamento(String departamentoId) {
        String sql = "SELECT id, nome, matricula, cargo, altura, departamento_id FROM funcionarios WHERE departamento_id = ?";
        return jdbcTemplate.query(sql, this::mapRow, departamentoId);
    }

    @Override
    public List<Funcionario> findAll() {
        String sql = "SELECT id, nome, matricula, cargo, altura, departamento_id FROM funcionarios";
        return jdbcTemplate.query(sql, this::mapRow);
    }
}
