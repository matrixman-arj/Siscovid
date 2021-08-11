package br.mil.eb.decex.siscovid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.mil.eb.decex.siscovid.controller.page.PageWrapper;
import br.mil.eb.decex.siscovid.model.UnidadeMilitarSaude;
import br.mil.eb.decex.siscovid.repository.UMSs;
import br.mil.eb.decex.siscovid.repository.filter.UMSFilter;
import br.mil.eb.decex.siscovid.service.CadastroUMSService;
import br.mil.eb.decex.siscovid.service.exception.UMSJaCadastradaException;

@Controller
@RequestMapping("/umss")
public class UMSsController {
		
	@Autowired
	private UMSs umss;
	
	
	@Autowired
	private CadastroUMSService cadastroUMSService;
	
	@RequestMapping("/nova")
	public ModelAndView nova(UnidadeMilitarSaude unidadeMilitarSaude) {
		ModelAndView mv = new ModelAndView("unidadeSaude/CadastroUMS");		
		mv.addObject("unidadesMilitaresSaude", umss.findAll());
		
		return mv;
	}
	
	@RequestMapping(value= "/nova", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid UnidadeMilitarSaude unidadeMilitarSaude, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute(unidadeMilitarSaude);
			return nova(unidadeMilitarSaude);
			
		}
		
		try {
			cadastroUMSService.salvar(unidadeMilitarSaude);
		} catch (UMSJaCadastradaException e) {
			result.rejectValue("sigla", e.getMessage(), e.getMessage());
			return nova(unidadeMilitarSaude);
			
		}		
		attributes.addFlashAttribute("mensagem", "Unidade Militar de Saúde salva com sucesso! ");
		return new ModelAndView("redirect:/umss/nova");
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid UnidadeMilitarSaude ums, BindingResult result ) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage());
		}
		
		ums = cadastroUMSService.salvar(ums);
		return ResponseEntity.ok(ums);
	}
	
	@GetMapping
	public ModelAndView pesquisar(UMSFilter umsFilter, BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("unidadeSaude/PesquisaUMSs");			
		mv.addObject("uCiviss", umss.findAll());
		
		PageWrapper<UnidadeMilitarSaude> paginaWrapper = new PageWrapper<>(umss.filtrar(umsFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		
		return mv;
				
	}
	
}
