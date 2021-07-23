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

import br.mil.eb.decex.siscovid.model.OrganizacaoMilitar;
import br.mil.eb.decex.siscovid.repository.OMs;
import br.mil.eb.decex.siscovid.service.CadastroOMService;
import br.mil.eb.decex.siscovid.service.exception.OMJaCadastradaException;

@Controller
public class OMsController {
		
	@Autowired
	private OMs oms;
	
	
	@Autowired
	private CadastroOMService cadastroOMService;
	
	@RequestMapping("/oms/nova")
	public ModelAndView nova(OrganizacaoMilitar organizacaoMilitar) {
		ModelAndView mv = new ModelAndView("organizacaoMilitar/CadastroOM");		
		mv.addObject("organizacoesMilitares", oms.findAll());
		
		return mv;
	}
	
	@RequestMapping(value= "/oms/nova", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid OrganizacaoMilitar organizacaoMilitar, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute(organizacaoMilitar);
			return nova(organizacaoMilitar);
			
		}
		
		try {
			cadastroOMService.salvar(organizacaoMilitar);
		} catch (OMJaCadastradaException e) {
			result.rejectValue("sigla", e.getMessage(), e.getMessage());
			return nova(organizacaoMilitar);
			
		}		
		attributes.addFlashAttribute("mensagem", "Organização Militar salva com sucesso! ");
		return new ModelAndView("redirect:/oms/nova");
		
	}	
	
}
