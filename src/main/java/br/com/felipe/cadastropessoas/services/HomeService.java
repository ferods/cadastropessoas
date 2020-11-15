package br.com.felipe.cadastropessoas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.felipe.cadastropessoas.models.DadosCompletosOuIncompletos;
import br.com.felipe.cadastropessoas.models.Pessoa;
import br.com.felipe.cadastropessoas.repositories.PessoaRepository;


@Service
public class HomeService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public String listar(Model model) {
		
		List<Pessoa> pessoas = pessoaRepository.findAll();
		model.addAttribute("pessoas", pessoas);
		
		return "home";
	}

	public String mostrarDadosCompletosOuIncompletos(String dados, Model model) {
		List<Pessoa> pessoas = pessoaRepository.findByDadosCompletosOuIncompletos(DadosCompletosOuIncompletos.valueOf(dados.toUpperCase()));
		model.addAttribute("pessoas", pessoas);
		return "home";
	}
}
