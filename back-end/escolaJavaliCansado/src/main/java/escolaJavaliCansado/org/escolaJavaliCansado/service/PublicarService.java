package escolaJavaliCansado.org.escolaJavaliCansado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escolaJavaliCansado.org.escolaJavaliCansado.model.Publicar;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.PublicarRepository;

@Service
public class PublicarService {
	
	@Autowired
	public PublicarRepository publicarRepository;
	
	public List<Publicar> buscarTodos() {
		return publicarRepository.findAll();
	}
	
	public List<Publicar> buscarPoNomeAluno(String nomeAluno) {
		return publicarRepository.findAllByNomeAlunoContainingIgnoreCase(nomeAluno);
	}
	
	public List<Publicar> buscarPorSituacaoAluno(String situacaoAluno) {
		return publicarRepository.findAllByNomeAlunoContainingIgnoreCase(situacaoAluno);
	}
}
