package br.mil.eb.decex.siscovid.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mil.eb.decex.siscovid.model.Paciente;

@Controller
public class PessoasController {
	
	@RequestMapping("/pessoas/novo")
	public String novo(Model model) {
		model.addAttribute(new Paciente());
		return "pessoa/CadastroPessoa";
	}
	
	@RequestMapping(value= "/pessoas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Paciente pessoa, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute(pessoa);
			return "pessoa/CadastroPessoa";
			
		}
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso! ");
		return "redirect:/pessoas/novo";		
	}
	
	@RequestMapping("/pessoas/cadastro")
	public String cadastro() {
		return "pessoa/cadastro-produto";
	}

}
