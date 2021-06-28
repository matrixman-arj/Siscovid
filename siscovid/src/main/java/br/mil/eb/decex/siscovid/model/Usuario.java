package br.mil.eb.decex.siscovid.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.mil.eb.decex.siscovid.enumerated.Perfil;
import br.mil.eb.decex.siscovid.enumerated.Status;

public class Usuario extends Pessoa{
	
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	private String senha;	
	
	@Column(name = "confirmacao_senha")
	private String confirmacaoSenha;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
		
}
