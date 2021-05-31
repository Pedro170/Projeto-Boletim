package org.escolasBrasil.escolaJavaliCansado.controller;

import java.util.List;

import org.escolasBrasil.escolaJavaliCansado.model.PostagemNota;
import org.escolasBrasil.escolaJavaliCansado.repository.PostagemNotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicar")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemNotaController {
	@Autowired
	private PostagemNotaRepository repositoryPostagem;
	
	@GetMapping
	public ResponseEntity<List<PostagemNota>> getAll() {
		return ResponseEntity.ok(repositoryPostagem.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<PostagemNota>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repositoryPostagem.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/situacao/{situacao}")
	public ResponseEntity<List<PostagemNota>> getBySituacao(@PathVariable String situacao) {
		return ResponseEntity.ok(repositoryPostagem.findAllBySituacaoContainingIgnoreCase(situacao));
	}
	
	
	@PostMapping
	public ResponseEntity<PostagemNota> post(@RequestBody PostagemNota postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryPostagem.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<PostagemNota> put(@RequestBody PostagemNota postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryPostagem.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repositoryPostagem.deleteById(id);
	}
}
