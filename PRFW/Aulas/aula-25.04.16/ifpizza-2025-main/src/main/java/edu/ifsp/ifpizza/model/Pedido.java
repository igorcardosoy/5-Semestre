package edu.ifsp.ifpizza.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Pedido {
	private Long id;
	private Date dataCriacao;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private List<Pizza> pizzas = new ArrayList<>(1);

	@NotBlank(message = "Informe o nome do cliente")
	private String cliente;
	
	@NotBlank(message = "Informe o endereço")
	private String endereco;
	
	@NotBlank(message = "Informe a cidade")
	private String cidade;
	
	@NotBlank(message = "Informe o estado")
	private String estado;
	
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato: 99999-999")
	private String cep;
	
	@NotBlank(message = "Informe o número")
	//@CreditCardNumber
	private String cartaoNumero;
	
	@Digits(integer = 3, fraction = 0, message = "Informe o CVV")
	private String cartaoCVV;
	
	@Pattern(regexp = "\\d{2}/\\d{4}", message = "Formato: mm/aaaa")
	private String cartaoExpiracao;


	public void add(Pizza pizza) {
		pizzas.add(pizza);
	}
}


