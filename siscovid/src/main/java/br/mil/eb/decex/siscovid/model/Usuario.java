package br.mil.eb.decex.siscovid.model;

import org.hibernate.validator.constraints.NotBlank;

import br.mil.eb.decex.siscovid.enumerated.Perfil;
import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;

public class Usuario {
			
	private long id;
	
	@NotBlank(message = "O campo nome é obrigatório! ")
	private String nome;
	@NotBlank(message = "O campo nome de guerra é obrigatório! ")
	private String nomeGuerra;
	
	private String identidade;	
	private PostoGraduacao posto;	
	private Perfil perfil;	
	private OrganizacaoMilitar om;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public PostoGraduacao getPosto() {
		return posto;
	}

	public void setPosto(PostoGraduacao posto) {
		this.posto = posto;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public OrganizacaoMilitar getOm() {
		return om;
	}

	public void setOm(OrganizacaoMilitar om) {
		this.om = om;
	}
	
	

}
