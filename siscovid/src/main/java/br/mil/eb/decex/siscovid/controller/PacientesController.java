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
import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;
import br.mil.eb.decex.siscovid.enumerated.TipoPaciente;
import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.OMs;
import br.mil.eb.decex.siscovid.repository.Pacientes;
import br.mil.eb.decex.siscovid.repository.filter.PacienteFilter;
import br.mil.eb.decex.siscovid.service.CadastroPacienteService;
import br.mil.eb.decex.siscovid.service.exception.IdentidadeJaCadastradaException;

@Controller
@RequestMapping("/pacientes")
public class PacientesController {
		
	@Autowired
	private OMs oms;
	
	@Autowired
	private Pacientes pacientes;
	
	@Autowired
	private CadastroPacienteService cadastroPacienteService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Pessoa paciente) {
		ModelAndView mv = new ModelAndView("paciente/CadastroPaciente");
		mv.addObject("postos", PostoGraduacao.values());
		mv.addObject("organizacoesMilitares", oms.findAll());
		mv.addObject("tipos", TipoPaciente.values());		
		mv.addObject("pacientes", pacientes.findAll());
		return mv;
	}
	
	@RequestMapping(value= "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Pessoa paciente, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute(paciente);
			return novo(paciente);
			
		}
		
		try {
			cadastroPacienteService.salvar(paciente);
		} catch (IdentidadeJaCadastradaException e) {
			result.rejectValue("identidade", e.getMessage(), e.getMessage());
			return novo(paciente);
			
		}
		attributes.addFlashAttribute("mensagem", "Paciente salvo com sucesso! ");
		return new ModelAndView("redirect:/pacientes/novo");
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Pessoa paciente, BindingResult result) {
				
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage());
		}
		
		try {
			paciente = cadastroPacienteService.salvar(paciente);
		} catch (IdentidadeJaCadastradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok(paciente);
	}
	
	@GetMapping
	public ModelAndView pesquisar(PacienteFilter pacienteFilter, BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("paciente/PesquisaPacientes");
		mv.addObject("postos", PostoGraduacao.values());	
		mv.addObject("organizacoesMilitares", oms.findAll());
		
		PageWrapper<Pessoa> paginaWrapper = new PageWrapper<>(pacientes.filtrar(pacienteFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		
		return mv;
				
	}
}
