package br.mil.eb.decex.siscovid.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.mil.eb.decex.siscovid.enumerated.TipoPaciente;

public class Paciente extends Pessoa{
	
	private static final long serialVersionUID = 1L;

	
	@Enumerated(EnumType.STRING)
	public TipoPaciente tipoPaciente;
	
	@ManyToOne
	@JoinColumn(name = "codigo_infectado")
	private Infectado infectado;	
		
		
	public TipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}

	public void setTipoPaciente(TipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}

	public Infectado getInfectado() {
		return infectado;
	}

	public void setInfectado(Infectado infectado) {
		this.infectado = infectado;
	}

		
}


