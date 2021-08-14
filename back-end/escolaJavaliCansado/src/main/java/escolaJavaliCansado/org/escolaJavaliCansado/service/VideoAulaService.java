package escolaJavaliCansado.org.escolaJavaliCansado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escolaJavaliCansado.org.escolaJavaliCansado.model.VideoAula;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.VideoAulaRepository;

@Service
public class VideoAulaService {
	@Autowired public VideoAulaRepository videoRepository;
	
	public List<VideoAula> buscarTodos() {
		return videoRepository.findAll();
	}
	
	public List<VideoAula> buscarPorTitulo(String tituloVideo) {
		return videoRepository.findAllByTituloDoVideoContainingIgnoreCase(tituloVideo);
	}
	
	public List<VideoAula> buscarPorDescricao(String descricaoVideo) {
		return videoRepository.findAllByDescricaoDoVideoContainingIgnoreCase(descricaoVideo);
	}
	
	public List<VideoAula> buscarPorMateria(String materia) {
		return videoRepository.findAllByMateriaContainingIgnoreCase(materia);
	}

}
