package br.mil.eb.decex.siscovid.enumerated;

public enum Status {
	
	CNV("convalescença"),
	ENTUBADO("Entubado"),
	RECUPERADO("Recuperado"),
	OBITO("Óbito");
	
private String value;
	
	private Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
