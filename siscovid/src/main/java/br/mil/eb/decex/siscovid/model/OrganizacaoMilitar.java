package br.mil.eb.decex.siscovid.model;

public class OrganizacaoMilitar {
	
	private Long id;
	private String sigla;
	private String descricao;
	private OrganizacaoMilitar omPai;
	private int ordem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OrganizacaoMilitar getOmPai() {
		return omPai;
	}
	public void setOmPai(OrganizacaoMilitar omPai) {
		this.omPai = omPai;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	

}
