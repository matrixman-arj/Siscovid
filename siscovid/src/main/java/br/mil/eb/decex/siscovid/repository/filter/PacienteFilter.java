package br.mil.eb.decex.siscovid.repository.filter;

import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;
import br.mil.eb.decex.siscovid.model.OrganizacaoMilitar;

public class PacienteFilter {
	
	private String identidade;
	private PostoGraduacao posto;
	private String nomeGuerra;
	private OrganizacaoMilitar om;
	
		
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
	
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	
	public OrganizacaoMilitar getOm() {
		return om;
	}
	public void setOm(OrganizacaoMilitar om) {
		this.om = om;
	}
	
}
