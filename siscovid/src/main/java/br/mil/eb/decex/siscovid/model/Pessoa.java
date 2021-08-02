package br.mil.eb.decex.siscovid.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.enumerated.Perfil;
import br.mil.eb.decex.siscovid.enumerated.PostoGraduacao;
import br.mil.eb.decex.siscovid.enumerated.TipoPaciente;
import br.mil.eb.decex.siscovid.validation.IDT;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PESSOA_CODIGO_GENERATOR",sequenceName = "PESSOA_CODIGO_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PESSOA_CODIGO_GENERATOR")
	private long codigo;
	
	@NotBlank(message = "O campo nome é obrigatório! ")
	private String nome;
	
	@NotBlank(message = "O campo nome de guerra é obrigatório! ")
	@Column(name = "nome_guerra")
	private String nomeGuerra;
	
	@IDT
	@NotBlank(message = "Identidade é obrigatória")
	private String identidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "posto_graduacao")
	@NotNull(message = "O posto é obrigatório")
	private PostoGraduacao posto;
			
	@ManyToOne
    @JoinColumn(name = "om_codigo")
	@NotNull(message = "A OM é obrigatória")
	
    private OrganizacaoMilitar om;
	
	@NotBlank(message = "E-mail é obrigatório")	
	@Email(message = "E-mail inválido")
	private String email;
	
	@Enumerated(EnumType.STRING)
//	@NotNull(message = "O campo perfil é obrigatório")
	private Perfil perfil;
	
//	@NotBlank(message = "O campo senha é obrigatório")
	private String senha;	
	
//	@NotBlank(message = "O campo confirmaçãode senha é obrigatório")
	@Column(name = "confirmacao_senha")
	private String confirmacaoSenha;
	
//	@NotBlank(message = "O campo acesso é obrigatório")
	private Boolean ativo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_paciente")
//	@NotNull(message = "O campo tipo é obrigatório")
	public TipoPaciente tipoPaciente;
	
	private String foto;
	
	@Column(name = "content_type")
	private String contentType;
	
	@Transient
	private boolean novaFoto;
	
//	@ManyToOne
//	@JoinColumn(name = "codigo_infectado")
//	private Infectado infectado;
	
	
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
		
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public TipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}

	public void setTipoPaciente(TipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}	

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public boolean isNovaFoto() {
		return novaFoto;
	}

	public void setNovaFoto(boolean novaFoto) {
		this.novaFoto = novaFoto;
	}
	
	public String getFotoOuMock() {
		return !StringUtils.isEmpty(foto) ? foto : "usuario-mock.jpg";
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
		Pessoa other = (Pessoa) obj;
		return codigo == other.codigo;
	}

}
