package br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import lombok.EqualsAndHashCode;

// @Validated
@EqualsAndHashCode
public class UserRequest {

	@NotNull(message = "O CPF é obrigatório")
	@CPF(message = "CPF inválido: deve ter 11 dígitos com dígito verificador correto")
	private String cpf; // chave

	@NotNull(message = "O Nome é obrigatório")
	@Pattern(regexp = "^\\w{2,}.*", message = "Nome inválido: deve ter pelo menos duas letras")
	private String name;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pessoa " + cpf + " " + name;
	}

}
