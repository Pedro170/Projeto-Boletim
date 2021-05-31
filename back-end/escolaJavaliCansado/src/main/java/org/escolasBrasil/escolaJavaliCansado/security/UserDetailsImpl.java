package org.escolasBrasil.escolaJavaliCansado.security;

import java.util.Collection;

import org.escolasBrasil.escolaJavaliCansado.model.Usuarios;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javassist.SerialVersionUID;

public class UserDetailsImpl implements UserDetails {
	
	private static final long SerialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	
	// constructor
	public UserDetailsImpl() {
		super();
	}

	public UserDetailsImpl(Usuarios user) {
		this.userName = user.getEmail();
		this.password = user.getSenha();
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
