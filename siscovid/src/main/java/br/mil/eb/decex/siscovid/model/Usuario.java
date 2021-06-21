package br.mil.eb.decex.siscovid.model;

import org.hibernate.validator.constraints.NotBlank;

import br.mil.eb.decex.siscovid.enumerated.Perfil;
import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;

public class Usuario {
			
	private long codigo;
	
	@NotBlank(message = "O campo nome é obrigatório! ")
	private String nome;
	@NotBlank(message = "O campo nome de guerra é obrigatório! ")
	private String nomeGuerra;
	
	private String identidade;	
	private PostoGraduacao posto;	
	private Perfil perfil;	
	private OrganizacaoMilitar om;
	@NotBlank(message = "E-mail é obrigatório")
	//@Email(message = "E-mail inválido")
	private String email;

	private String senha;	
	
	private String confirmacaoSenha;	
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	private Boolean ativo;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	
	
	
}
