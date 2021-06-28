package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;

@Entity
@Table(name = "usuario")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotBlank(message = "O campo nome é obrigatório! ")
	private String nome;
	
	@NotBlank(message = "O campo nome de guerra é obrigatório! ")
	@Column(name = "nome_guerra")
	private String nomeGuerra;
	
	private String identidade;
	
	@Enumerated(EnumType.STRING)
	private PostoGraduacao posto;
			
	@Enumerated(EnumType.STRING)
	private OrganizacaoMilitar om;
	
	@NotBlank(message = "E-mail é obrigatório")	
	//@Email(message = "E-mail inválido")
	private String email;
	
	@Embedded
	private Usuario usuario;
	
	@Embedded
	private Paciente paciente;
	
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	

	public PostoGraduacao getPosto() {
		return posto;
	}

	public void setPosto(PostoGraduacao posto) {
		this.posto = posto;
	}
	
	
	public OrganizacaoMilitar getOm() {
		return om;
	}

	public void setOm(OrganizacaoMilitar om) {
		this.om = om;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	private Boolean ativo;
	

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
		Pessoa other = (Pessoa) obj;
		return codigo == other.codigo;
	}
		
}
