package com.sopra.TPFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPFinal.model.User;

public interface UsersRepository extends JpaRepository<User, String>{

	
}
