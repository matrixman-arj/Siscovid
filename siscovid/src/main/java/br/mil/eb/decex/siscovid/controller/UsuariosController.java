package br.mil.eb.decex.siscovid.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mil.eb.decex.siscovid.model.Usuario;

@Controller
public class UsuariosController {
	
	@RequestMapping("/usuarios/novo")
	public String novo(Model model) {
		model.addAttribute(new Usuario());
		return "usuario/CadastroUsuario";
	}
	
	@RequestMapping(value= "/usuarios/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute(usuario);
			return "usuario/CadastroUsuario";
			
		}
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso! ");
		return "redirect:/usuarios/novo";		
	}

}
