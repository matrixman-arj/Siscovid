package br.mil.eb.decex.siscovid.model;

import org.springframework.format.annotation.DateTimeFormat;

import br.mil.eb.decex.siscovid.enumerated.LocalConvalescenca;
import br.mil.eb.decex.siscovid.enumerated.Status;

public class Infectado {
	
	private Long codigo;
	private Usuario codigo_usuario;
	private Status status;
	private LocalConvalescenca localConvelescenca;
	private DateTimeFormat data_inicial;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Usuario getCodigo_usuario() {
		return codigo_usuario;
	}
	public void setCodigo_usuario(Usuario codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
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
