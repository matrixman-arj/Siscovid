package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import br.mil.eb.decex.siscovid.enumerated.LocalConvalescenca;
import br.mil.eb.decex.siscovid.enumerated.Status;

public class Infectado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@OneToMany(mappedBy = "infectado")	
	private List<Paciente> pessoas;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "local_convalescenca")
	@Enumerated(EnumType.STRING)
	private LocalConvalescenca localConvelescenca;
	
	private DateTimeFormat data_inicial;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}	
	
	public List<Paciente> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Paciente> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public LocalConvalescenca getLocalConvelescenca() {
		return localConvelescenca;
	}
	public void setLocalConvelescenca(LocalConvalescenca localConvelescenca) {
		this.localConvelescenca = localConvelescenca;
	}
	
	public DateTimeFormat getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(DateTimeFormat data_inicial) {
		this.data_inicial = data_inicial;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Infectado other = (Infectado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
