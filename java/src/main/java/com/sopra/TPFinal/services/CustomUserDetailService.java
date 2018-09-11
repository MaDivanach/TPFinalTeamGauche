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
import com.sopra.TPFinal.repositories.UsersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository usersRepository;
	
	@Autowired
	private UserRoleRepositoy userRoleRepository;
	
	
	public UserRepository getUsersRepository() {
		return usersRepository;
	}


	public void setUsersRepository(UserRepository usersRepository) {
		this.usersRepository = usersRepository;
	}


	public UserRoleRepositoy getUserRoleRepository() {
		return userRoleRepository;
	}


	public void setUserRoleRepository(UserRoleRepositoy userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt=usersRepository.findById(username);
		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get(), userRoleRepository.findCustomRoleByUsername(username));
		} else {
			throw new UsernameNotFoundException("utilisateur inconnu");
		}
	
	}

}
