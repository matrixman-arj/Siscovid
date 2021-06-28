package br.mil.eb.decex.siscovid.enumerated;

public enum LocalConvalescenca {
	
	RESIDENCIA("Residência"),
	OMDS("Organização Militar de Saúde"),
	OCS("Organização Civil de Saúde");	
	
private String descricao;
	
	LocalConvalescenca(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
}
