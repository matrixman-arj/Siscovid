package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.mil.eb.decex.siscovid.enumerated.LocalConvalescenca;
import br.mil.eb.decex.siscovid.enumerated.Status;

@Entity
@Table(name = "infectado")
public class Infectado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "INFECTADO_CODIGO_GENERATOR",sequenceName = "INFECTADO_CODIGO_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "INFECTADO_CODIGO_GENERATOR")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "local_convalescenca")
	@Enumerated(EnumType.STRING)
	private LocalConvalescenca localConvalescenca;
	
	@ManyToOne
	@JoinColumn(name = "codigo_ums")
	private UnidadeMilitarSaude ums;
	
	@ManyToOne
	@JoinColumn(name = "codigo_ucs")
	private UnidadeCivilSaude ucs;
	
	@DateTimeFormat
	private LocalDateTime data_inicial;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}		
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public LocalConvalescenca getLocalConvalescenca() {
		return localConvalescenca;
	}
	public void setLocalConvalescenca(LocalConvalescenca localConvalescenca) {
		this.localConvalescenca = localConvalescenca;
	}	
		
	public UnidadeMilitarSaude getUms() {
		return ums;
	}
	public void setUms(UnidadeMilitarSaude ums) {
		this.ums = ums;
	}
	
	public UnidadeCivilSaude getUcs() {
		return ucs;
	}
	public void setUcs(UnidadeCivilSaude ucs) {
		this.ucs = ucs;
	}
	
	public LocalDateTime getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(LocalDateTime data_inicial) {
		this.data_inicial = data_inicial;
	}
	
	@PrePersist
	private void prePersist() {		
		status = Status.CNV;
		data_inicial = LocalDateTime.now();
	}

	@PreUpdate
	private void prePersistUpdate() {
		data_inicial = LocalDateTime.now();
		
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
