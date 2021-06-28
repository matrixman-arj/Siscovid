package br.mil.eb.decex.siscovid.enumerated;

/**
 * Enumerado dos Postos e Graduações das 
 * Forças Armadas
 * 
 * @author William Moreira de Pinho - 1º Ten QCO
 * @version 1.0
 */
public enum PostoGraduacao {

	GEN_EXERCITO("Gen Ex"),
	GEN_DIVISAO("Gen Div"),
	GEN_BRIGADA("Gen Bda"),
	CORONEL("Cel"),
	TEN_CORONEL("Ten Cel"),
	MAJOR("Maj"),
	CAPITAO("Cap"),
	PRI_TENENTE("1º Ten"),
	SEG_TENENTE("2º Ten"),
	ASP("Asp"),
	SUBTENENTE("S Ten"),
	PRI_SARGENTO("1º SGT"),
	SEG_SARGENTO("2º SGT"),
	TER_SARGENTO("3º SGT"),
	CABO("Cabo"),
	T_MOR("Taifeiro Mor"),
	T1("Taifeiro de 1ª classe"),
	T2("Taifeiro de 2ª classe"),
	SOLDADO("Soldado"),
	SVD_CIV("Servidor Civil");
	
	private String descricao;
	
	PostoGraduacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}