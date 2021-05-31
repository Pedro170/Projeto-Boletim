package org.escolasBrasil.escolaJavaliCansado.service;

import java.util.List;

import org.escolasBrasil.escolaJavaliCansado.model.PostagemNota;
import org.escolasBrasil.escolaJavaliCansado.repository.PostagemNotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemNotaService {
	@Autowired
	public PostagemNotaRepository repositoryPostagem;
	
	public List<PostagemNota> listaTodasNotas() {
		return repositoryPostagem.findAll();
	}
	
	public List<PostagemNota> litaPorNome(String nome) {
		return repositoryPostagem.findAllByNomeContainingIgnoreCase(nome);
	}
}
