package escolaJavaliCansado.org.escolaJavaliCansado.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idUser;
	@NotNull @Size(min = 3, message = "[ERRO] O nome não pode ser vazio e o mínimo de caracteres permitido é de 3") String nome;
	@NotNull(message = "[ERRO] É obrigatório colocar um e-mail, pois vamos usar ele como identificador") private String email;
	@NotNull(message = "[ERRO] O número mínimo de caractere para senha é de cinco") private String senha;
	private String tipo;
	private String foto;
	
	// Relações entre as tabelas usuários, publicar e vídeo Aulas
	
	@OneToMany(mappedBy = "publicadoPor")
	@JsonIgnoreProperties("publicadoPor")
	private List<Publicar> meusBoletins = new ArrayList<>();
	
	@OneToMany(mappedBy = "publicadoPor")
	@JsonIgnoreProperties("publicadoPor")
	private List<VideoAula> meusVideos = new ArrayList<>();
	
	// Constructor
	
	public Usuarios() {
		super();
		
	}

	public Usuarios(Long idUser,
			@NotNull @Size(min = 3, message = "[ERRO] O nome não pode ser vazio e o mínimo de caracteres permitido é de 3") String nome,
			@NotNull(message = "[ERRO] É obrigatório colocar um e-mail, pois vamos usar ele como identificador") String email,
			@NotNull(message = "[ERRO] O número mínimo de caractere para senha é de cinco") String senha, String tipo,
			String foto, List<Publicar> meusBoletins, List<VideoAula> meusVideos) {
		super();
		this.idUser = idUser;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.foto = foto;
		this.meusBoletins = meusBoletins;
		this.meusVideos = meusVideos;
	}


	// Getters and Setters
		
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Publicar> getMeusBoletins() {
		return meusBoletins;
	}

	public void setMeusBoletins(List<Publicar> meusBoletins) {
		this.meusBoletins = meusBoletins;
	}

	public List<VideoAula> getMeusVideos() {
		return meusVideos;
	}

	public void setMeusVideos(List<VideoAula> meusVideos) {
		this.meusVideos = meusVideos;
	}
}
