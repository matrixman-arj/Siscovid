package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.mil.eb.decex.siscovid.enumerated.TipoPaciente;

@Embeddable
public class Paciente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Enumerated(EnumType.STRING)
	public TipoPaciente tipoPaciente;
	
//	@ManyToOne
//	@JoinColumn(name = "codigo_infectado")
//	private Infectado infectado;	
		
		
	public TipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}

	public void setTipoPaciente(TipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}
		
}


