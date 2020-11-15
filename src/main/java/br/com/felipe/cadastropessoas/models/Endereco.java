package br.com.felipe.cadastropessoas.models;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private Long cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cidade;
	private String bairro;

	public Endereco(Long cep, String logradouro, Integer numero, String complemento, String cidade, String bairro) {

		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.bairro = bairro;

	}
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
