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
import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.OMs;

@Controller
public class UsuariosController {
	
	@Autowired
	private OMs oms;
	
	@RequestMapping("/usuarios/novo")
	public ModelAndView novo(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("postos", PostoGraduacao.values());
		mv.addObject("organizacoesMilitares", oms.findAll());
		mv.addObject("perfis", Perfil.values());
		return mv;
	}
	
	@RequestMapping(value= "/usuarios/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Pessoa pessoa, BindingResult result, Model model, RedirectAttributes attributes) {
//		if (result.hasErrors()) {
//			model.addAttribute(usuario);
//			return "usuario/CadastroUsuario";
//			
//		}
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso! ");
		System.out.println(">>> Nome de guerra: " + pessoa.getNomeGuerra());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("OM: " + pessoa.getOm());
		System.out.println("Posto: " + pessoa.getPosto());
		System.out.println("Perfil: " + pessoa.getUsuario().getPerfil());
		return new ModelAndView("redirect:/usuarios/novo");		
	}
	
	
}
