package br.mil.eb.decex.siscovid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mil.eb.decex.siscovid.controller.page.PageWrapper;
import br.mil.eb.decex.siscovid.enumerated.Perfil;
import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;
import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.OMs;
import br.mil.eb.decex.siscovid.repository.Usuarios;
import br.mil.eb.decex.siscovid.repository.filter.UsuarioFilter;
import br.mil.eb.decex.siscovid.service.CadastroUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private OMs oms;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Pessoa usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("postos", PostoGraduacao.values());
		mv.addObject("organizacoesMilitares", oms.findAll());
		mv.addObject("perfis", Perfil.values());
		return mv;
	}
	
	@RequestMapping(value= "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Pessoa usuario, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {		
			return novo (usuario);
			
		}
		
		cadastroUsuarioService.salvar(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso! ");
		return new ModelAndView("redirect:/usuarios/novo");		
	}
	
	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter usuarioFilter, BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("usuario/PesquisaUsuarios");
		mv.addObject("postos", PostoGraduacao.values());
		mv.addObject("grupos", Perfil.values() );
		mv.addObject("organizacoesMilitares", oms.findAll());
		
		PageWrapper<Pessoa> paginaWrapper = new PageWrapper<>(usuarios.filtrar(usuarioFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		
		return mv;
				
	}
}
