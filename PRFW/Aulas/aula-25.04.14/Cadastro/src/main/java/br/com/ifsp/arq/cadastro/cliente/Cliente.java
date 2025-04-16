package br.com.ifsp.arq.cadastro.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private String nome;
    private String email;
    private boolean ativo;
}
