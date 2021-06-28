package br.mil.eb.decex.siscovid.enumerated;

public enum TipoPaciente {
	
	CORPO_PERMANENTE("Corpo permanente"),
	CADETE("Cadete"),
	ALUNO("Aluno"),
	Instrutor("Instrutor");
	
	private String descrcao;
	
	TipoPaciente(String descricao) {
		this.descrcao = descricao;		
	}

	public String getDescrcao() {
		return descrcao;
	}
	
}
