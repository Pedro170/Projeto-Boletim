package escolaJavaliCansado.org.escolaJavaliCansado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaJavaliCansado.org.escolaJavaliCansado.model.Publicar;

@Repository
public interface PublicarRepository extends JpaRepository<Publicar, Long> {
	public List<Publicar> findAllByNomeAlunoContainingIgnoreCase(String nomeAluno);
	public List<Publicar> findAllBySituacaoContainingIgnoreCase(String situacaoAluno);
}
