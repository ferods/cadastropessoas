package br.com.felipe.cadastropessoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.felipe.cadastropessoas.services.HomeService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	@Autowired
	private HomeService homeService;

	@GetMapping
	public String home(Model model) {				
		return homeService.listar(model);
	}
	
	@GetMapping("/{dados}")
	public String mostrarDadosCompletosOuIncompletos(@PathVariable("dados") String dados, Model model) {
		return homeService.mostrarDadosCompletosOuIncompletos(dados, model);
	}

}
