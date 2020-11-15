package br.com.felipe.cadastropessoas.formsdto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.felipe.cadastropessoas.models.DadosCompletosOuIncompletos;
import br.com.felipe.cadastropessoas.models.Pessoa;
import br.com.felipe.cadastropessoas.repositories.PessoaRepository;

public class RequisicaoAlterarPessoa {

	@NotBlank
	private String nomeAlterar;
	private Long cepAlterar;
	private String logradouroAlterar;
	private Integer numeroAlterar;
	private String complementoAlterar;
	private String cidadeAlterar;
	private String bairroAlterar;
	private String dataNascimentoAlterar;
	private String nomeMaeAlterar;
	private String telefonePrincipalAlterar;
	private String telefoneSecundarioAlterar;
	private String emailAlterar;
//	private String urlImagem;
	private String dadosCompletosOuIncompletosAlterar;

	public String getNomeAlterar() {
		return nomeAlterar;
	}

	public void setNomeAlterar(String nomeAlterar) {
		this.nomeAlterar = nomeAlterar;
	}

	public Long getCepAlterar() {
		return cepAlterar;
	}

	public void setCepAlterar(Long cepAlterar) {
		this.cepAlterar = cepAlterar;
	}

	public String getLogradouroAlterar() {
		return logradouroAlterar;
	}

	public void setLogradouroAlterar(String logradouroAlterar) {
		this.logradouroAlterar = logradouroAlterar;
	}

	public Integer getNumeroAlterar() {
		return numeroAlterar;
	}

	public void setNumeroAlterar(Integer numeroAlterar) {
		this.numeroAlterar = numeroAlterar;
	}

	public String getComplementoAlterar() {
		return complementoAlterar;
	}

	public void setComplementoAlterar(String complementoAlterar) {
		this.complementoAlterar = complementoAlterar;
	}

	public String getCidadeAlterar() {
		return cidadeAlterar;
	}

	public void setCidadeAlterar(String cidadeAlterar) {
		this.cidadeAlterar = cidadeAlterar;
	}

	public String getBairroAlterar() {
		return bairroAlterar;
	}

	public void setBairroAlterar(String bairroAlterar) {
		this.bairroAlterar = bairroAlterar;
	}

	public String getDataNascimentoAlterar() {
		return dataNascimentoAlterar;
	}

	public void setDataNascimentoAlterar(String dataNascimentoAlterar) {
		this.dataNascimentoAlterar = dataNascimentoAlterar;
	}

	public String getNomeMaeAlterar() {
		return nomeMaeAlterar;
	}

	public void setNomeMaeAlterar(String nomeMaeAlterar) {
		this.nomeMaeAlterar = nomeMaeAlterar;
	}

	public String getTelefonePrincipalAlterar() {
		return telefonePrincipalAlterar;
	}

	public void setTelefonePrincipalAlterar(String telefonePrincipalAlterar) {
		this.telefonePrincipalAlterar = telefonePrincipalAlterar;
	}

	public String getTelefoneSecundarioAlterar() {
		return telefoneSecundarioAlterar;
	}

	public void setTelefoneSecundarioAlterar(String telefoneSecundarioAlterar) {
		this.telefoneSecundarioAlterar = telefoneSecundarioAlterar;
	}

	public String getEmailAlterar() {
		return emailAlterar;
	}

	public void setEmailAlterar(String emailAlterar) {
		this.emailAlterar = emailAlterar;
	}
	
	public String getDadosCompletosOuIncompletosAlterar() {
		return dadosCompletosOuIncompletosAlterar;
	}
	public void setDadosCompletosOuIncompletosAlterar(String dadosCompletosOuIncompletosAlterar) {
		this.dadosCompletosOuIncompletosAlterar = dadosCompletosOuIncompletosAlterar;
	}

	public void alterar(Long cpfPessoa, PessoaRepository pessoaRep) {
		
		
		
		Pessoa pessoa = pessoaRep.getOne(cpfPessoa);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		CharSequence data = this.dataNascimentoAlterar;
		LocalDate dataNas = LocalDate.parse(data, formatter);

		pessoa.getEndereco().setCep(this.cepAlterar);
		pessoa.getEndereco().setLogradouro(this.logradouroAlterar);
		pessoa.getEndereco().setNumero(this.numeroAlterar);
		pessoa.getEndereco().setComplemento(this.complementoAlterar);
		pessoa.getEndereco().setBairro(this.bairroAlterar);
		pessoa.getEndereco().setCidade(this.cidadeAlterar);
		pessoa.setNome(this.nomeAlterar);
		pessoa.setDataNascimento(dataNas);
		pessoa.setNomeMae(this.nomeMaeAlterar);
		pessoa.setTelefonePrincipal(this.telefonePrincipalAlterar);
		pessoa.setTelefoneSecundario(this.telefoneSecundarioAlterar);
		pessoa.setEmail(this.emailAlterar);
		
		
		if(this.dadosCompletosOuIncompletosAlterar.contentEquals("COMPLETOS")) {
		pessoa.setDadosCompletosOuIncompletos(DadosCompletosOuIncompletos.COMPLETOS);
		} else {
			pessoa.setDadosCompletosOuIncompletos(DadosCompletosOuIncompletos.INCOMPLETOS);
		}
	}

}
