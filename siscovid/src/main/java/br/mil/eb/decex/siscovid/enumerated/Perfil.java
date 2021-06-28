package br.mil.eb.decex.siscovid.enumerated;

public enum Perfil {
	
	HOMOLOGADOR("Auditório"),
	GERENTE("Gerente"),
	ADMINISTRADOR("Administrador"),
	USUARIO("Usuário");	
	
	private String descricao;

	Perfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
		
}
