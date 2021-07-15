package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.mil.eb.decex.siscovid.enumerated.Perfil;

@Embeddable
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo perfil é obrigatório")
	private Perfil perfil;
	
	@NotBlank(message = "O campo senha é obrigatório")
	private String senha;	
	
	@NotBlank(message = "O campo confirmaçãode senha é obrigatório")
	@Column(name = "confirmacao_senha")
	private String confirmacaoSenha;
	
	@NotBlank(message = "O campo acesso é obrigatório")
	private Boolean ativo;

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
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}	
		
}
