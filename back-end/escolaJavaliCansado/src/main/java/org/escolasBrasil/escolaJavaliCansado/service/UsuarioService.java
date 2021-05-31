package org.escolasBrasil.escolaJavaliCansado.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
//import org.escolasBrasil.escolaJavaliCansado.model.PostagemNota;
import org.escolasBrasil.escolaJavaliCansado.model.UserLogin;
import org.escolasBrasil.escolaJavaliCansado.model.Usuarios;
import org.escolasBrasil.escolaJavaliCansado.repository.PostagemNotaRepository;
import org.escolasBrasil.escolaJavaliCansado.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
	@Autowired
	public UsuariosRepository repositoryUsuario;
	
	@Autowired
	public PostagemNotaRepository repositoryPostagem;
	
	public Optional<Usuarios> cadastrar(Usuarios usuario) {
		Optional<Usuarios> usuarioExistente = repositoryUsuario.findByEmail(usuario.getEmail());
		if(usuarioExistente.isPresent()) {
			return Optional.empty();
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return Optional.ofNullable(repositoryUsuario.save(usuario));
	}
	
	public Optional<UserLogin> logar(Optional<UserLogin> userLogin) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuarios> usuarioPresente = repositoryUsuario.findByEmail(userLogin.get().getEmail());
		
		if(usuarioPresente.isPresent()) {
			if(encoder.matches(userLogin.get().getSenha(), usuarioPresente.get().getSenha())) {
				String auth = userLogin.get().getEmail() + ":" + userLogin.get().getSenha();
				byte[] encoderAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encoderAuth);
				
				userLogin.get().setToken(authHeader);
				userLogin.get().setIdUsuario(usuarioPresente.get().getIdUsuario());
				userLogin.get().setNome(usuarioPresente.get().getNome());
				userLogin.get().setFoto(usuarioPresente.get().getFoto());
				userLogin.get().setTipo(usuarioPresente.get().getTipo());
				
				return userLogin;
			}
		}
		
		return null;
	}
	
	/*
	public PostagemNota publicarNota(PostagemNota novaNota, Long idUsuario) {
		PostagemNota postagemExistente = repositoryPostagem.save(novaNota);
		Optional<Usuarios> usuarioExistente = repositoryUsuario.findById(idUsuario);
		if(usuarioExistente.isPresent())
	}
	*/
}
