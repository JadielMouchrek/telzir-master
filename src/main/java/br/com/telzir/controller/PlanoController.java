package br.com.telzir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.telzir.domain.Cidade;
import br.com.telzir.domain.TipoPlano;
import br.com.telzir.dto.FormularioDTO;
import br.com.telzir.repository.TipoPlanoRepository;
import br.com.telzir.service.CidadeService;
import br.com.telzir.service.PlanoService;
import javassist.tools.rmi.ObjectNotFoundException;

/*
 * Classe controller com as rotas para acesso aos templates da aplicação
 * 
 * */

@Controller
public class PlanoController {

	@Autowired
	PlanoService planoService;

	@Autowired
	CidadeService cidadeService;
	
	
	/*
	 * Rota de request para mostrar o formulario
	 * Parametros: model para ser passado ao template do thymleaf
	 * */
	
	@GetMapping("/telzir-form")
	public String telzirFormularioPlanos(Model model) {
		try {
			List<Cidade> cidadesDisponiveis = cidadeService.findCidades();
			List<TipoPlano> planos = planoService.findPlanos();
			
			if(cidadesDisponiveis.size() <= 0 && planos.size() <= 0) {
				return "algoinesperado";
			}
			
			FormularioDTO formulario = new FormularioDTO(cidadesDisponiveis, planos);
			model.addAttribute("formulario", formulario);
			return "telzir-form";
		} catch (Exception e) {
			System.out.println("Erro telzir-form: " + e.getMessage());
			return "algoinesperado";
		}
	}

	/*
	 * Rota de post para prover as informacoes passadas do formulario
	 * Parametros: Class Formulario DTO com as informações escolhidas pelo usuario,
	 * Model para resultado do calculo dos planos 
	 * 
	 */
	
	@PostMapping("/telzir-form")
	public String telzirResultadoPlano(@ModelAttribute(value = "formulario") FormularioDTO formulario, Model model) {
		try {
			
			if(formulario == null) {
				return "algoinesperado";
			}
			
			Double valorComplano = planoService.calcularValoresFormulario(formulario);
			formulario.setPlano("");
			Double valorSemPlano = planoService.calcularValoresFormulario(formulario);

			model.addAttribute("comPlano", valorComplano);
			model.addAttribute("semPlano", valorSemPlano);

			return "telzir-result";
		} catch (Exception e) {
			System.out.println("Erro telzir-result: " + e.getMessage());
			return "algoinesperado";
		}

	}

	

}
