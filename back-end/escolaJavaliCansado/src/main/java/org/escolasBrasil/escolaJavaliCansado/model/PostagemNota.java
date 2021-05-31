package org.escolasBrasil.escolaJavaliCansado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagemNota")
public class PostagemNota {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idPostagem;
	private @NotNull @Size(message = "O nome não pode ser vazio") String Aluno;
	private @NotNull Float bimestre1;
	private @NotNull Float bimestre2;
	private @NotNull Float bimestre3;
	private @NotNull Float bimestre4;
	private @NotNull Float media;
	private @NotNull String situacao;
	
	// Relacionando as Tabelas Postagens e Usuários
	@ManyToOne
	@JsonIgnoreProperties("publicar")
	private Usuarios usuarios;
	
	// CONSTRUCTOR
	
	public PostagemNota() {
		super();
		
	}
	
	public PostagemNota(Long idPostagem, @NotNull @Size(message = "O nome não pode ser vazio") String aluno,
			@NotNull Float bimestre1, @NotNull Float bimestre2, @NotNull Float bimestre3, @NotNull Float bimestre4,
			@NotNull Float media, @NotNull String situacao, Usuarios usuarios) {
		super();
		this.idPostagem = idPostagem;
		Aluno = aluno;
		this.bimestre1 = bimestre1;
		this.bimestre2 = bimestre2;
		this.bimestre3 = bimestre3;
		this.bimestre4 = bimestre4;
		this.media = media;
		this.situacao = situacao;
		this.usuarios = usuarios;
	}
	
	//Getter and Setters	
	

	public Long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getAluno() {
		return Aluno;
	}

	public void setAluno(String aluno) {
		Aluno = aluno;
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

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
}
