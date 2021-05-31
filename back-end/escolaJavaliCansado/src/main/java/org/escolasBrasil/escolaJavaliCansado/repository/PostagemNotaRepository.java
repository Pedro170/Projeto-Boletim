package org.escolasBrasil.escolaJavaliCansado.repository;

import java.util.List;

import org.escolasBrasil.escolaJavaliCansado.model.PostagemNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemNotaRepository extends JpaRepository<PostagemNota, Long>{
	public List<PostagemNota> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<PostagemNota> findAllBySituacaoContainingIgnoreCase(String situacao);
}
