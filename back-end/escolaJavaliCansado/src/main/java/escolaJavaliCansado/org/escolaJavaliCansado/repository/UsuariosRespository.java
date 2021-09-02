package escolaJavaliCansado.org.escolaJavaliCansado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaJavaliCansado.org.escolaJavaliCansado.model.Usuarios;

@Repository
public interface UsuariosRespository extends JpaRepository<Usuarios, Long> {
	public Optional<Usuarios> findByEmail(String email);
	public Optional<Usuarios> findByTipo(String tipo);
}
