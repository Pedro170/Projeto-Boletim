package org.escolasBrasil.escolaJavaliCansado.model;

public class UserLogin {
	private Long idUsuario;
	private String nome;
	private String email;
	private String senha;
	private String foto;
	private String tipo;
	private String token;
	
	// CONSTRUCTOR
	public UserLogin() {
		super();
		
	}
	
	public UserLogin(Long idUsuario, String nome, String email, String senha, String foto, String tipo, String token) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
		this.token = token;
	}
	
	// Getters and Setters
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
