package br.mil.eb.decex.siscovid.service.event.paciente;

import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.model.Pessoa;

public class PacienteSalvoEvent {
	
	private Pessoa pessoa;
	
	public PacienteSalvoEvent(Pessoa pessoa) {
		
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public boolean temFoto() {
		return !StringUtils.isEmpty(pessoa.getFoto());
	}
	
	public boolean isNovaFoto() {
		return pessoa.isNovaFoto();
	}
}
