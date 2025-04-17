package edu.ifsp.ifpizza.persistence;

import edu.ifsp.ifpizza.model.Ingrediente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredienteRepositorio implements IngredienteRepositorio {
    private final JdbcTemplate jdbcTemplate;

    public JdbcIngredienteRepositorio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingrediente> findAll() {
        return jdbcTemplate.query(
                "select id, nome, tipo from ingrediente",
                this :: mapRow
        );
    }
    private Ingrediente mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Ingrediente(
                rs.getString("id"),
                rs.getString("nome"),
                Ingrediente.Tipo.valueOf(rs.getString("tipo"))
        );
    }

    @Override
    public Ingrediente find(String id) {
        return jdbcTemplate.queryForObject(
                "select id, nome, tipo from ingrediente where id = ?",
                this::mapRow, id
        );
    }

    @Override
    public Ingrediente save(Ingrediente ingrediente) {
        jdbcTemplate.update(
                "insert into ingrediente (id, nome, tipo) values (?, ?, ?)",
                ingrediente.getId(),
                ingrediente.getNome(),
                ingrediente.getTipo()
        );

        return ingrediente;
    }
}
