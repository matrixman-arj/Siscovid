package br.mil.eb.decex.siscovid.service.event.usuario;

import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.model.Pessoa;

public class UsuarioSalvoEvent {
	
	private Pessoa pessoa;
	
	public UsuarioSalvoEvent(Pessoa pessoa) {
		
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
