package br.com.felipe.cadastropessoas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.com.felipe.cadastropessoas.formsdto.RequisicaoAlterarPessoa;
import br.com.felipe.cadastropessoas.formsdto.RequisicaoNovaPessoa;
import br.com.felipe.cadastropessoas.services.PessoasService;

@Controller
@RequestMapping("/pessoas")
public class PessoasController {
	
	@Autowired
	private PessoasService pessoasService;

	@GetMapping("/cadastrar")
	public String formulario(RequisicaoNovaPessoa requisicaoNovaPessoa) {
		return pessoasService.formularioParaCadastrar(requisicaoNovaPessoa);
	}
	
	@PostMapping
	public String salvar(@Valid RequisicaoNovaPessoa requisicaoNovaPessoa, BindingResult br, MultipartFile imagem) {
		return pessoasService.salvar(imagem, requisicaoNovaPessoa, br);
	}
	
	
	@GetMapping("/detalhes{id}")
	public String detalhar(Long id, Model model) {
		return pessoasService.detalhar(id, model);
	}
	
	
	
	@GetMapping("/alterar{id}")
	public String formularioAlterar(Long id, Model model, RequisicaoAlterarPessoa requisicaoAlterarPessoa) {
		return pessoasService.formularioParaAtualizar(id, model, requisicaoAlterarPessoa);		
	}
	
	@PostMapping("/alterar")
	public String alterar(RequisicaoAlterarPessoa requisicaoAlterarPessoa, Long cpfPessoa) {
		return pessoasService.alterar(requisicaoAlterarPessoa, cpfPessoa);
	}
	
	
	@PostMapping("/remover")
	public String remover(Long pessoaCpfRemover) {
		return pessoasService.remover(pessoaCpfRemover);		
	}

}
