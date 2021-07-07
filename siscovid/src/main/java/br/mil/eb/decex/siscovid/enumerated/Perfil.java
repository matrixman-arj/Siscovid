package br.mil.eb.decex.siscovid.enumerated;

public enum Perfil {
	
	ADMINISTRADOR("Administrador"),
	GERENTE("Gerente"),
	HOMOLOGADOR("Homologador"),
	USUARIO("Usuário");	
	
	private String descricao;

	Perfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
		
}
