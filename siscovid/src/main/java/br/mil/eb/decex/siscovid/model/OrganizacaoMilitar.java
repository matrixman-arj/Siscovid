package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "om")
public class OrganizacaoMilitar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String sigla;
	private String descricao;
	
	@Column(name = "om_pai_codigo")
	private OrganizacaoMilitar omPai;
	
	private OrganizacaoMilitar secao;
	
	private int ordem;
		
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
	public OrganizacaoMilitar getOmPai() {
		return omPai;
	}
	public void setOmPai(OrganizacaoMilitar omPai) {
		this.omPai = omPai;
	}
	
	public OrganizacaoMilitar getSecao() {
		return secao;
	}
	public void setSecao(OrganizacaoMilitar secao) {
		this.secao = secao;
	}
	
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizacaoMilitar other = (OrganizacaoMilitar) obj;
		return Objects.equals(codigo, other.codigo);
	}	
	
}
