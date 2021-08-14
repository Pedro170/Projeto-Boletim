package escolaJavaliCansado.org.escolaJavaliCansado.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import escolaJavaliCansado.org.escolaJavaliCansado.model.Publicar;
import escolaJavaliCansado.org.escolaJavaliCansado.model.UsuarioLogin;
import escolaJavaliCansado.org.escolaJavaliCansado.model.Usuarios;
import escolaJavaliCansado.org.escolaJavaliCansado.model.VideoAula;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.UsuariosRespository;
import escolaJavaliCansado.org.escolaJavaliCansado.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {

	@Autowired private UsuarioService usuarioService;
	
	@Autowired private UsuariosRespository usuarioRespository;
	
	//@Autowired private PublicarRepository publicarRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getById(@PathVariable Long idUsuario){
		return usuarioRespository.findById(idUsuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastro(@Valid @RequestBody Usuarios usuario) {
        Optional<Usuarios> usuarioCadastrado = usuarioService.cadastrar(usuario);
        if(usuarioCadastrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Usuário existente");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado.get());
        }

    }
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> auth(@RequestBody Optional<UsuarioLogin> usuarioLogin)  {
		return usuarioService.logar(usuarioLogin)
				.map(userLogin -> ResponseEntity.ok(userLogin))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/publicar/nova/{id_user}")
	public ResponseEntity<?> novaPublicacao(
			@PathVariable(value = "id_user") Long idUser,
			@Valid @RequestBody Publicar novaPublicacao) {
		Publicar cadastro = usuarioService.cadastrarPublicacao(novaPublicacao, idUser);
		if(cadastro == null) {
			return new ResponseEntity<String>("Falha no cadastro", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Publicar>(cadastro, HttpStatus.CREATED);
	}
	
	@PostMapping("/publicarVideo/novo/{id_user}")
	public ResponseEntity<?> novoVideo(
			@PathVariable(value = "id_user") Long idUser,
			@Valid @RequestBody VideoAula novoVideo) {
		VideoAula cadastro = usuarioService.publicarVideo(novoVideo, idUser);
		if(cadastro == null) {
			return new ResponseEntity<String>("Falha na publicação do vídeo", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<VideoAula>(cadastro, HttpStatus.CREATED);
	}
	
	@GetMapping("/nome")
	public ResponseEntity<List<Usuarios>> buscarPorNomeDoAluno(@RequestParam(defaultValue = "") String nomeDoAluno) {
		return new ResponseEntity<List<Usuarios>>(HttpStatus.OK);
	}
	
	@PutMapping("/publicar/edite/{id_User}")
	public ResponseEntity<?> editarBoletim(
			@PathVariable(value = "id_User") Long idUser,
			@Valid @RequestBody Publicar publicar) {
		Optional<Publicar> alterado = usuarioService.editarBoletim(idUser, publicar);
		if(alterado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicação existente");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(alterado.get());
		}
	}

	/*@PutMapping
	public ResponseEntity<?> alterar(@RequestBody Usuarios usuarios) {
		Optional<Usuarios> alterado = service.alterar(usuarios);
		if (alterado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário Inexistente");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(alterado.get());
		}
	}

	@PutMapping("/alterar/senha")
	public ResponseEntity<?> alterarSenha(@RequestBody Usuarios usuarios) {
		Optional<Usuarios> alterado = service.alterarSenha(usuarios);
		if (alterado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário Inexistente");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(alterado.get());
		}
	}*/

	/*
	@PutMapping
	public ResponseEntity<Usuarios> put(@RequestBody Usuarios usuario){
		return ResponseEntity.ok(repository.save(usuario));
	}
	*/
}