package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.mil.eb.decex.siscovid.enumerated.LocalConvalescenca;
import br.mil.eb.decex.siscovid.enumerated.Status;

@Entity
@Table(name = "infectado")
public class Infectado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@OneToMany(mappedBy = "infectado")	
	private List<Pessoa> pessoas;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "local_convalescenca")
	@Enumerated(EnumType.STRING)
	private LocalConvalescenca localConvelescenca;
	
	private LocalDateTime data_inicial;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}	
		
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
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
		
	public LocalDateTime getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(LocalDateTime data_inicial) {
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
