package br.mil.eb.decex.siscovid.model;

import br.mil.eb.decex.siscovid.enumerated.TipoPessoa;

public class Pessoa extends Usuario{
	public TipoPessoa tipoPessoa;

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}	
	
}


