package escolaJavaliCansado.org.escolaJavaliCansado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaJavaliCansado.org.escolaJavaliCansado.model.VideoAula;

@Repository 
public interface VideoAulaRepository extends JpaRepository<VideoAula, Long> {
	public List<VideoAula> findAllByTituloDoVideoContainingIgnoreCase(String tituloDoVideo);
	public List<VideoAula> findAllByDescricaoDoVideoContainingIgnoreCase(String descricaoDoVideo);
	public List<VideoAula> findAllByMateriaContainingIgnoreCase(String materia);
}