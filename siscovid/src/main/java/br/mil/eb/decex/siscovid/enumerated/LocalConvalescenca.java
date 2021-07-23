package br.mil.eb.decex.siscovid.enumerated;

public enum LocalConvalescenca {
	
	RESIDENCIA("Residência"),
	UMS("Unidade Militar de Saúde"),
	UCS("Unidade Civil de Saúde");	
	
private String descricao;
	
	LocalConvalescenca(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
}
