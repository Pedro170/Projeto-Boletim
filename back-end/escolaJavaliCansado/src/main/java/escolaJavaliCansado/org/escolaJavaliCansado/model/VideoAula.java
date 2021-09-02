package escolaJavaliCansado.org.escolaJavaliCansado.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_videoAula")

public class VideoAula {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idVideo;
	@Size(min = 5, message="[ERRO] o mínimo de caractere é de cinco!") private String tituloDoVideo;
	@Size(max = 200, message="[ERRO] o máximo de caracteres é de 200!") private String descricaoDoVideo;
	@Temporal(TemporalType.DATE) private Date dataPublicacao;
	private String atividade;
	private String materia;
	private String videoAula;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "ProfessorCriador")
	@JsonIgnoreProperties("meusVideos")
	private Usuarios publicadoPor;
	
	// Constructor
	
	public VideoAula() {
		super();
	}
	
	public VideoAula(Long idVideo,
			@Size(min = 5, message = "[ERRO] o mínimo de caractere é de cinco!") String tituloDoVideo,
			@Size(max = 200, message = "[ERRO] o máximo de caracteres é de 200!") String descricaoDoVideo,
			@NotNull Date dataPublicacao, String atividade, String materia, String videoAula, Usuarios publicadoPor) {
		super();
		this.idVideo = idVideo;
		this.tituloDoVideo = tituloDoVideo;
		this.descricaoDoVideo = descricaoDoVideo;
		this.dataPublicacao = dataPublicacao;
		this.atividade = atividade;
		this.materia = materia;
		this.videoAula = videoAula;
		this.publicadoPor = publicadoPor;
	}

	// Getters and Setters
	
	public Long getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(Long idVideo) {
		this.idVideo = idVideo;
	}
	public String getTituloDoVideo() {
		return tituloDoVideo;
	}
	public void setTituloDoVideo(String tituloDoVideo) {
		this.tituloDoVideo = tituloDoVideo;
	}
	public String getDescricaoDoVideo() {
		return descricaoDoVideo;
	}
	public void setDescricaoDoVideo(String descricaoDoVideo) {
		this.descricaoDoVideo = descricaoDoVideo;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getVideoAula() {
		return videoAula;
	}
	public void setVideoAula(String videoAula) {
		this.videoAula = videoAula;
	}

	public Usuarios getPublicadoPor() {
		return publicadoPor;
	}

	public void setPublicadoPor(Usuarios publicadoPor) {
		this.publicadoPor = publicadoPor;
	}
}
