package escolaJavaliCansado.org.escolaJavaliCansado.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_publicar")
public class Publicar {
	// Attribute
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idPublicar;
	@NotNull @Size(min = 3, message="O número mínimo de caracteres são três!") private String nomeAluno;
	@NotNull private Float bimestre1, bimestre2, bimestre3, bimestre4, media;
	@Size(min = 5, message = "[ERRO] O mínimo de caracteres são de 15!") private String situacao;
	
	// Relações entre as tabelas publicar e usuários
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "ProfessorCriador")
	@JsonIgnoreProperties("meusBoletins")
	private Usuarios publicadoPor;
	
	// Constructor


	// Getters and Setters

	public Long getIdPublicar() {
		return idPublicar;
	}

	public void setIdPublicar(Long idPublicar) {
		this.idPublicar = idPublicar;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Float getBimestre1() {
		return bimestre1;
	}

	public void setBimestre1(Float bimestre1) {
		this.bimestre1 = bimestre1;
	}

	public Float getBimestre2() {
		return bimestre2;
	}

	public void setBimestre2(Float bimestre2) {
		this.bimestre2 = bimestre2;
	}

	public Float getBimestre3() {
		return bimestre3;
	}

	public void setBimestre3(Float bimestre3) {
		this.bimestre3 = bimestre3;
	}

	public Float getBimestre4() {
		return bimestre4;
	}

	public void setBimestre4(Float bimestre4) {
		this.bimestre4 = bimestre4;
	}

	public Float getMedia() {
		return media;
	}

	public void setMedia(Float media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Usuarios getPublicadoPor() {
		return publicadoPor;
	}

	public void setPublicadoPor(Usuarios publicadoPor) {
		this.publicadoPor = publicadoPor;
	}
}
