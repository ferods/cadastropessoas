package br.com.felipe.cadastropessoas.formsdto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.felipe.cadastropessoas.models.Endereco;
import br.com.felipe.cadastropessoas.models.Pessoa;

public class RequisicaoNovaPessoa {
	
	@NotNull
	private Long cpf;
	@NotBlank
	private String nome; 	
	private Long cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cidade;
	private String bairro;
	private String dataNascimento;
	private String nomeMae;
	private String telefonePrincipal;
	private String telefoneSecundario;
	private String email;
	private String dadosCompletosOuIncompletos;
//	private String urlImagem;
	
	
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}
	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}
	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}
	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDadosCompletosOuIncompletos() {
		return dadosCompletosOuIncompletos;
	}
	public void setDadosCompletosOuIncompletos(String dadosCompletosOuIncompletos) {
		this.dadosCompletosOuIncompletos = dadosCompletosOuIncompletos;
	}
//	public String getUrlImagem() {
//		return urlImagem;
//	}
//	public void setUrlImagem(String urlImagem) {
//		this.urlImagem = urlImagem;
//	}
	
	
	public Pessoa toPessoa() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		CharSequence data = dataNascimento;
		LocalDate dataNas = LocalDate.parse(data , formatter);
		
		Endereco endereco = new Endereco(cep, logradouro, numero, complemento, cidade, bairro);
		return new Pessoa(cpf, nome, endereco , dataNas, nomeMae, telefonePrincipal, telefoneSecundario, email, dadosCompletosOuIncompletos);
	}	
	

}
