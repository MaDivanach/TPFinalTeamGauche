package com.sopra.TPFinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sopra.TPFinal.model.User;
import com.sopra.TPFinal.repositories.UserRepository;
import com.sopra.TPFinal.repositories.UserRoleRepositoy;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepositoy userRoleRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRoleRepositoy getUserRoleRepository() {
		return userRoleRepository;
	}

	public void setUserRoleRepository(UserRoleRepositoy userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}

//	@Override
//	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	 @Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 Optional<User> opt = userRepository.findCustomByUsername(username);
	 if (opt.isPresent()) {
	 return new CustomUserDetails(opt.get(),opt.get().getRole());
	 } else {
	 throw new UsernameNotFoundException("utilisateur inconnu");
	 }
	
	 }

}
