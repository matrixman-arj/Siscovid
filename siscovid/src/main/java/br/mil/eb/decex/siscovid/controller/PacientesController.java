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

import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;
import br.mil.eb.decex.siscovid.enumerated.Status;
import br.mil.eb.decex.siscovid.enumerated.TipoPaciente;
import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.OMs;
import br.mil.eb.decex.siscovid.repository.Pessoas;

@Controller
public class PacientesController {
		
	@Autowired
	private OMs oms;
	
	@Autowired
	private Pessoas pessoas;
	
	@RequestMapping("/pacientes/novo")
	public ModelAndView novo(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView("paciente/CadastroPaciente");
		mv.addObject("postos", PostoGraduacao.values());
		mv.addObject("organizacoesMilitares", oms.findAll());
		mv.addObject("tipos", TipoPaciente.values());
		mv.addObject("status", Status.values());
		mv.addObject("pessoas", pessoas.findAll());
		return mv;
	}
	
	@RequestMapping(value= "/pacientes/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Pessoa pessoa, BindingResult result, Model model, RedirectAttributes attributes) {
//		if (result.hasErrors()) {
//			model.addAttribute(pessoa);
//			return "pessoa/CadastroPessoa";
			
//		}
		attributes.addFlashAttribute("mensagem", "Paciente salvo com sucesso! ");
		return new ModelAndView("redirect:/pacientes/novo");		
	}
	
}
