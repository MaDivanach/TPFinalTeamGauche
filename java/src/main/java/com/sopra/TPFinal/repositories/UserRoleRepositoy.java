package com.sopra.TPFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPFinal.model.UserRole;


public interface UserRoleRepositoy extends JpaRepository<UserRole, Integer> {
 
}
