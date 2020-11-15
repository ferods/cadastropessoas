package br.com.felipe.cadastropessoas.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pessoa {
	
	@Id
	private Long cpf;
	private String nome; 	
	@Embedded
	private Endereco endereco;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private String nomeMae;
	private String telefonePrincipal;
	private String telefoneSecundario;
	private String email;
	private String urlImagem;
	@Enumerated(EnumType.STRING)
	private DadosCompletosOuIncompletos dadosCompletosOuIncompletos;
	
	public Pessoa(Long cpf,	String nome, Endereco endereco,	LocalDate dataNascimento, String nomeMae,
			String telefonePrincipal, String telefoneSecundario, String email, String dadosCompletosOuIncompletos) {
		
		this.cpf = cpf;
		this.nome = nome; 				
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.nomeMae = nomeMae;
		this.telefonePrincipal = telefonePrincipal;
		this.telefoneSecundario = telefoneSecundario;
		this.email = email;	
		
		if(dadosCompletosOuIncompletos.contentEquals("COMPLETOS")){
		 this.dadosCompletosOuIncompletos = DadosCompletosOuIncompletos.COMPLETOS;	
		} else {
			this.dadosCompletosOuIncompletos = DadosCompletosOuIncompletos.INCOMPLETOS;
		}
		
	}
	
	public Pessoa() {
		
	}
	
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
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
	
	public String getUrlImagem() {
		return urlImagem;
	}
	
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public DadosCompletosOuIncompletos getDadosCompletosOuIncompletos() {
		return dadosCompletosOuIncompletos;
	}
	
	public void setDadosCompletosOuIncompletos(DadosCompletosOuIncompletos dadosCompletosOuIncompletos) {
		this.dadosCompletosOuIncompletos = dadosCompletosOuIncompletos;
	}
	
	
	
	
	
	

}
