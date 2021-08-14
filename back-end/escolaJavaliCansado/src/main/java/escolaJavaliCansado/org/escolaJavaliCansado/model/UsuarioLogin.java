package escolaJavaliCansado.org.escolaJavaliCansado.model;

public class UsuarioLogin {
	private Long idUser;
	private String nome, email, senha, tipo, foto, token;
	
	// Constructor
	
	public UsuarioLogin() {
		super();
	}
	public UsuarioLogin(Long idUser, String nome, String email, String senha, String tipo, String foto, String token) {
		super();
		this.idUser = idUser;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.foto = foto;
		this.token = token;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
