package br.com.felipe.cadastropessoas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.cadastropessoas.models.DadosCompletosOuIncompletos;
import br.com.felipe.cadastropessoas.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByDadosCompletosOuIncompletos(DadosCompletosOuIncompletos dadosCompletosOuIncompletos);

}
