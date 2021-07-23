package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ucs")
public class UnidadeCivilSaude implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "UCS_CODIGO_GENERATOR",sequenceName = "UCS_CODIGO_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "UCS_CODIGO_GENERATOR")
	private Long codigo;
	
	@NotBlank(message = "O campo sigla é obrigatório")
	private String sigla;
	
	@NotBlank(message = "O campo descrição é obrigatório")
	private String descricao;	
	
	private String endereco;	
	
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
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		UnidadeCivilSaude other = (UnidadeCivilSaude) obj;
		return Objects.equals(codigo, other.codigo);
	}	
	
}
