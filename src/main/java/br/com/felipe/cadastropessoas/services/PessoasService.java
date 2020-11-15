package br.com.felipe.cadastropessoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.felipe.cadastropessoas.components.FileSaver;
import br.com.felipe.cadastropessoas.formsdto.RequisicaoAlterarPessoa;
import br.com.felipe.cadastropessoas.formsdto.RequisicaoNovaPessoa;
import br.com.felipe.cadastropessoas.models.Pessoa;
import br.com.felipe.cadastropessoas.repositories.PessoaRepository;

@Service
@Transactional
public class PessoasService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public String formularioParaCadastrar(RequisicaoNovaPessoa requisicaoNovaPessoa) {		
		return "pessoas/formulario";
	}

	

	public String salvar(MultipartFile imagem ,RequisicaoNovaPessoa requisicaoNovaPessoa, BindingResult br) {
		
		if(br.hasErrors()) {
			return "pessoas/formulario";
		}
		
		 Pessoa pessoa = requisicaoNovaPessoa.toPessoa();
		 
		 String path = fileSaver.write("arquivoimagens", imagem);
		 pessoa.setUrlImagem(path);
		 pessoaRepository.save(pessoa);
		return "redirect:home";
	}
	
	
	
	

	public String detalhar(Long id, Model model) {
		Pessoa pessoa = pessoaRepository.getOne(id);
		model.addAttribute("pessoa", pessoa);
		return "pessoas/detalhes";
	}





	public String formularioParaAtualizar(Long id, Model model, RequisicaoAlterarPessoa requisicaoAlterarPessoa) {
		Pessoa pessoa = pessoaRepository.getOne(id);
		model.addAttribute("pessoa", pessoa );
		return "pessoas/formularioalteracao";
	}




	public String alterar(RequisicaoAlterarPessoa requisicaoAlterarPessoa, Long cpfPessoa) {
		
		requisicaoAlterarPessoa.alterar(cpfPessoa, pessoaRepository);
		return "redirect:/home";
	}



	public String remover(Long pessoaCpfRemover) {
		pessoaRepository.deleteById(pessoaCpfRemover);
		return "redirect:/home";
	}

}
