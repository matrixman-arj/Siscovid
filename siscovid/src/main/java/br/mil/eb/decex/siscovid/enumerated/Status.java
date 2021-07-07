package br.mil.eb.decex.siscovid.enumerated;

public enum Status {
	
	CNV("Convalescença"),
	ENTUBADO("Entubado"),
	RECUPERADO("Recuperado"),
	OBITO("Óbito");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
}
