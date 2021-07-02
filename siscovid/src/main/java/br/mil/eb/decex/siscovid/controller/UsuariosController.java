package br.mil.eb.decex.siscovid.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mil.eb.decex.siscovid.enumerated.Perfil;
import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;
import br.mil.eb.decex.siscovid.model.Usuario;
import br.mil.eb.decex.siscovid.repository.OMs;

@Controller
public class UsuariosController {
	
	@Autowired
	private OMs oms;
	
	@RequestMapping("/usuarios/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("postos", PostoGraduacao.values());
		mv.addObject("organizacoesMilitares", oms.findAll());
		mv.addObject("perfis", Perfil.values());
		return mv;
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
	
	@RequestMapping("/usuarios/cadastro")
	public String cadastro() {
		return "usuario/cadastro-produto";
	}

}
