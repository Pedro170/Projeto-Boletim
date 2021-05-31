package org.escolasBrasil.escolaJavaliCansado.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
	private @NotNull String nome;
	private @NotNull String email;
	private @NotNull String senha;
	private String foto;
	private String tipo;
	
	// Relacionando Tabelas Usuários e Postagem
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuarios")
	private List<PostagemNota> publicar;
	
	// Constructor
	
	public Usuarios() {
		super();
		
	}

	public Usuarios(Long idUsuario, @NotNull String nome, @NotNull String email, @NotNull String senha, String foto,
			String tipo, List<PostagemNota> publicar) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
		this.publicar = publicar;
	}
	
	//Getters and Setters

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

	public List<PostagemNota> getPublicar() {
		return publicar;
	}

	public void setPublicar(List<PostagemNota> publicar) {
		this.publicar = publicar;
	}
}
