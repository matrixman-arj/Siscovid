package br.mil.eb.decex.siscovid.enumerated;

public enum LocalConvalescenca {
	
	RESIDENCIA("Residência"),
	OMDS("Organização Militar de Saúde"),
	OCS("Organização Civil de Saúde");	
	
private String value;
	
	private LocalConvalescenca(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
