package br.mil.eb.decex.siscovid.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mil.eb.decex.siscovid.model.Infectado;

@Controller
public class InfectadosController {
	
	@RequestMapping("/infectados/novo")
	public String novo(Model model) {
		model.addAttribute(new Infectado());
		return "infectado/CadastroInfectado";
	}
	
	@RequestMapping(value= "/infectados/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Infectado infectado, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute(infectado);
			return "infectado/CadastroInfectado";
			
		}
		attributes.addFlashAttribute("mensagem", "Infectado salvo com sucesso! ");
		return "redirect:/infectados/novo";		
	}
	
	@RequestMapping("/infectados/cadastro")
	public String cadastro() {
		return "infectado/cadastro-produto";
	}

}
