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
import br.mil.eb.decex.siscovid.model.UnidadeCivilSaude;
import br.mil.eb.decex.siscovid.repository.UCSs;
import br.mil.eb.decex.siscovid.repository.filter.UCSFilter;
import br.mil.eb.decex.siscovid.service.CadastroUCSService;
import br.mil.eb.decex.siscovid.service.exception.UCSJaCadastradaException;

@Controller
@RequestMapping("/ucss")
public class UCSsController {
		
	@Autowired
	private UCSs ucss;
	
	
	@Autowired
	private CadastroUCSService cadastroUCSService;
	
	@RequestMapping("/nova")
	public ModelAndView nova(UnidadeCivilSaude unidadeCivilSaude) {
		ModelAndView mv = new ModelAndView("unidadeSaude/CadastroUCS");		
		mv.addObject("unidadesCivisSaude", ucss.findAll());
		
		return mv;
	}
	
	@RequestMapping(value= "/nova", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid UnidadeCivilSaude unidadeCivilSaude, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute(unidadeCivilSaude);
			return nova(unidadeCivilSaude);
			
		}
		
		try {
			cadastroUCSService.salvar(unidadeCivilSaude);
		} catch (UCSJaCadastradaException e) {
			result.rejectValue("sigla", e.getMessage(), e.getMessage());
			return nova(unidadeCivilSaude);
			
		}		
		attributes.addFlashAttribute("mensagem", "Unidade Civil de Saúde salva com sucesso! ");
		return new ModelAndView("redirect:/ucss/nova");
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid UnidadeCivilSaude ucs, BindingResult result ) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage());
		}
		
		ucs = cadastroUCSService.salvar(ucs);
		return ResponseEntity.ok(ucs);
	}
	
	@GetMapping
	public ModelAndView pesquisar(UCSFilter ucsFilter, BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("unidadeSaude/PesquisaUCSs");			
		mv.addObject("uCiviss", ucss.findAll());
		
		PageWrapper<UnidadeCivilSaude> paginaWrapper = new PageWrapper<>(ucss.filtrar(ucsFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		
		return mv;
				
	}
	
}
