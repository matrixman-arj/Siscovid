package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import br.mil.eb.decex.siscovid.enumerated.Status;
import br.mil.eb.decex.siscovid.enumerated.TipoPaciente;

@Embeddable
public class Paciente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_paciente")
	public TipoPaciente tipoPaciente;
	
	@OneToMany(mappedBy = "pessoa")	
	private List<Infectado> infectados;
	
	@Enumerated(EnumType.STRING)
	private Status status;		
		
	public TipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}

	public void setTipoPaciente(TipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}

	public List<Infectado> getInfectados() {
		return infectados;
	}

	public void setInfectados(List<Infectado> infectados) {
		this.infectados = infectados;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	

		
}


