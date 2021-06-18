package br.mil.eb.decex.siscovid.enumerated;

public enum Perfil {
	
	USUARIO("Usuário"),
	ADMINISTRADOR("Administrador"),
	AUDITORIO("Auditório");
	
private String value;
	
	private Perfil(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
