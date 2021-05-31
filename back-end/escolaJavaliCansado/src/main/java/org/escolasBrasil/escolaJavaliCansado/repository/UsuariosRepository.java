package org.escolasBrasil.escolaJavaliCansado.repository;

import java.util.List;
import java.util.Optional;

import org.escolasBrasil.escolaJavaliCansado.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	//public List<Usuarios> findByUsuarios(String usuarios);
	
	public Optional<Usuarios> findByEmail(String email);
	
	@Query(value = "SELECT * FROM usuarios INNER JOIN postagemNotas"
	+ "criador=id_usuarios"
	+ "WHERE usuarios.nome LIKE %:nome%",
	nativeQuery = true)
	public List<Usuarios> findByUsuariosEmail(@Param("nome") String nome);
}
