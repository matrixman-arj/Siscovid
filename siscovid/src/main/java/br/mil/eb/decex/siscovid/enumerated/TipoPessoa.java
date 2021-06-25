package br.mil.eb.decex.siscovid.enumerated;

public enum TipoPessoa {
	
	CORPO_PERMANENTE("Corpo permanente"),
	CADETE("Cadete"),
	ALUNO("Aluno"),
	Instrutor("Instrutor");
	
private String value;
	
	private TipoPessoa(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
