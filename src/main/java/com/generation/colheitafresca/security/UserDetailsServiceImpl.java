package com.generation.colheitafresca.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.colheitafresca.model.Usuario;
import com.generation.colheitafresca.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = repository.findByEmail(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " não encontrado."));
		return usuario.map(UserDetailsImpl::new).get();
	}
}
