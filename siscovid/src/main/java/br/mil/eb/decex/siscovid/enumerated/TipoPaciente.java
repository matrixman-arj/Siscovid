package br.mil.eb.decex.siscovid.enumerated;

public enum TipoPaciente {
	
	CORPO_PERMANENTE("Corpo permanente"),
	CADETE("Cadete"),
	ALUNO("Aluno"),
	Instrutor("Instrutor");
	
	private String descricao;
	
	TipoPaciente(String descricao) {
		this.descricao = descricao;		
	}

	public String getDescricao() {
		return descricao;
	}
	
}
