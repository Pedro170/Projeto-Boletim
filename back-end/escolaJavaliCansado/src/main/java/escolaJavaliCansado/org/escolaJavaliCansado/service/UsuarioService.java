package escolaJavaliCansado.org.escolaJavaliCansado.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import escolaJavaliCansado.org.escolaJavaliCansado.model.Publicar;
import escolaJavaliCansado.org.escolaJavaliCansado.model.UsuarioLogin;
import escolaJavaliCansado.org.escolaJavaliCansado.model.Usuarios;
import escolaJavaliCansado.org.escolaJavaliCansado.model.VideoAula;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.PublicarRepository;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.UsuariosRespository;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.VideoAulaRepository;


@Service
public class UsuarioService {

	@Autowired public UsuariosRespository usuarioRespository;
	
	@Autowired public PublicarRepository publicarRepository;
	@Autowired public PublicarService publicarService;
	
	@Autowired public VideoAulaRepository videoRepository;
	@Autowired public VideoAulaService videoService;
	
	public Optional<Usuarios> cadastrar(Usuarios usuario) {
        Optional<Usuarios> usuarioExistente = usuarioRespository.findByEmail(usuario.getEmail());
        if(usuarioExistente.isPresent()) {
            return Optional.empty();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        return Optional.ofNullable(usuarioRespository.save(usuario));
    }
	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> usuarioLogin){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuarios> usuarioPresente = usuarioRespository.findByEmail(usuarioLogin.get().getEmail());

		if(usuarioPresente.isPresent()) {
			if(encoder.matches(usuarioLogin.get().getSenha(), usuarioPresente.get().getSenha())) {
				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				usuarioLogin.get().setToken(authHeader);				
				usuarioLogin.get().setNome(usuarioPresente.get().getNome());
				usuarioLogin.get().setSenha(usuarioPresente.get().getSenha());
				usuarioLogin.get().setFoto(usuarioPresente.get().getFoto());
				usuarioLogin.get().setTipo(usuarioPresente.get().getTipo());
				usuarioLogin.get().setIdUser(usuarioPresente.get().getIdUser());

				return usuarioLogin;
			}
		}
		return null;
	}
	
	public Publicar cadastrarPublicacao(Publicar novaPublicacao, Long idUser) {
		Publicar publicacaoExistente = publicarRepository.save(novaPublicacao);
		Optional<Usuarios> usuarioExistente = usuarioRespository.findById(idUser);
		if(usuarioExistente.isPresent()) {
			publicacaoExistente.setPublicadoPor(usuarioExistente.get());
			
			return publicarRepository.save(publicacaoExistente);
		}
		return null;
	}
	
	public VideoAula publicarVideo(VideoAula novoVideo, Long IdUser) {
		VideoAula videoExistente = videoRepository.save(novoVideo);
		Optional<Usuarios> usuarioExistente = usuarioRespository.findById(IdUser);
		if(usuarioExistente.isPresent()) {
			videoExistente.setPublicadoPor(usuarioExistente.get());
			
			return videoRepository.save(videoExistente);
		}
		
		return null;
	}
	
	public List<Publicar> buscaPorNomeDoAluno (String nomeDoAluno){
		return publicarService.buscarPoNomeAluno(nomeDoAluno);
		
	}
	
	public Optional<Usuarios> alterar (Usuarios usuarios) {
		Optional<Usuarios> existente = usuarioRespository.findById(usuarios.getIdUser());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			existente.get().setNome(usuarios.getNome());
			existente.get().setFoto(usuarios.getFoto());
		}
		return Optional.ofNullable(usuarioRespository.save(existente.get()));
	}
	
	public Optional<Usuarios> alterarSenha(Usuarios usuarios) {
		Optional<Usuarios> existente = usuarioRespository.findByEmail(usuarios.getEmail());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	        String senhaEncoder = encoder.encode(usuarios.getSenha());
			existente.get().setSenha(senhaEncoder);
			return Optional.ofNullable(usuarioRespository.save(existente.get()));
		}
		
	}
	

	public Optional<Publicar> editarBoletim(Long idUser, Publicar publicar){
		Optional<Publicar> publicacaoExistente = publicarRepository.findById(publicar.getIdPublicar());
		Optional<Usuarios> usuarioExistente = usuarioRespository.findById(idUser);
		if(usuarioExistente.isPresent() && publicacaoExistente.isPresent()) {
			publicacaoExistente.get().setNomeAluno(publicar.getNomeAluno());
			publicacaoExistente.get().setBimestre1(publicar.getBimestre1());
			publicacaoExistente.get().setBimestre2(publicar.getBimestre2());
			publicacaoExistente.get().setBimestre3(publicar.getBimestre3());
			publicacaoExistente.get().setBimestre4(publicar.getBimestre4());
			publicacaoExistente.get().setMedia(publicar.getMedia());
			publicacaoExistente.get().setSituacao(publicar.getSituacao());
		}
		return Optional.ofNullable(publicarRepository.save(publicacaoExistente.get()));
	}
}
