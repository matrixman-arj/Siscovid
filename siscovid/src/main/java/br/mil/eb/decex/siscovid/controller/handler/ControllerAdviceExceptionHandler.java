package br.mil.eb.decex.siscovid.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.mil.eb.decex.siscovid.service.exception.IdentidadeJaCadastradaException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {
	
	@ExceptionHandler(IdentidadeJaCadastradaException.class)
	public ResponseEntity<String> handleNomeTipoCursoJaCadastradoException(IdentidadeJaCadastradaException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
		
	}

}
