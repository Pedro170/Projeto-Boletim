package org.escolasBrasil.escolaJavaliCansado.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.escolasBrasil.escolaJavaliCansado.model.UserLogin;
import org.escolasBrasil.escolaJavaliCansado.model.Usuarios;
//import org.escolasBrasil.escolaJavaliCansado.repository.PostagemNotaRepository;
import org.escolasBrasil.escolaJavaliCansado.repository.UsuariosRepository;
import org.escolasBrasil.escolaJavaliCansado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuariosController {
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private UsuariosRepository repositoryUsuario;
	
	/*
	 *@Autowired
	 *private PostagemNotaRepository respositoryPostagem;
	 */
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> getAll() {
		return ResponseEntity.ok(repositoryUsuario.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getById(@PathVariable Long idUsuario) {
		return repositoryUsuario.findById(idUsuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastro(@Valid @RequestBody Usuarios usuario) {
		Optional<Usuarios> usuarioCadastrado = serviceUsuario.cadastrar(usuario);
		if(usuarioCadastrado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Usuário existente");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado.get());
		}
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> auth(@RequestBody Optional<UserLogin> userLogin) {
		return serviceUsuario.logar(userLogin)
				.map(usuarioLogin -> ResponseEntity.ok(usuarioLogin))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
}
