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

import br.mil.eb.decex.siscovid.enumerated.LocalConvalescenca;
import br.mil.eb.decex.siscovid.enumerated.Perfil;
import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;
import br.mil.eb.decex.siscovid.enumerated.Status;
import br.mil.eb.decex.siscovid.enumerated.TipoPaciente;
import br.mil.eb.decex.siscovid.model.Infectado;
import br.mil.eb.decex.siscovid.repository.OMs;
import br.mil.eb.decex.siscovid.repository.Pessoas;
import br.mil.eb.decex.siscovid.repository.UCSs;
import br.mil.eb.decex.siscovid.repository.UMSs;

@Controller
@RequestMapping("/infectados")
public class InfectadosController {
	
	@Autowired
	private Pessoas pessoas;
	
	@Autowired
	private OMs oms;
	
	@Autowired
	private UMSs umss;
	
	@Autowired
	private UCSs ucss;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Infectado infectado) {
		ModelAndView mv = new ModelAndView("infectado/CadastroInfectado");
		mv.addObject("pessoas", pessoas.findAll());
		mv.addObject("postos", PostoGraduacao.values());
		mv.addObject("organizacoesMilitares", oms.findAll());
		mv.addObject("perfis", Perfil.values());
		mv.addObject("tipos", TipoPaciente.values());
		mv.addObject("status", Status.values());
		mv.addObject("locais", LocalConvalescenca.values());
		mv.addObject("umss", umss.findAll());
		mv.addObject("ucss", ucss.findAll());
		return mv;
		
	}
	
	@RequestMapping(value= "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Infectado infectado, BindingResult result, Model model, RedirectAttributes attributes) {
//		if (result.hasErrors()) {
//			model.addAttribute(infectado);
//			return "infectado/CadastroInfectado";
//			
//		}
		attributes.addFlashAttribute("mensagem", "Infectado salvo com sucesso! ");
		
		System.out.println(">>> Paciente: " + infectado.getPessoa().getCodigo());
		
		return new ModelAndView("redirect:/infectados/novo");
	}
	
}
