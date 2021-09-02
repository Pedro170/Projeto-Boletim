package escolaJavaliCansado.org.escolaJavaliCansado.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import escolaJavaliCansado.org.escolaJavaliCansado.model.Usuarios;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.UsuariosRespository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuariosRespository usuariosRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuarios> usuarios = usuariosRepository.findByEmail(userName);
		usuarios.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		return usuarios.map(UserDetailsImpl::new).get();
	}
}
