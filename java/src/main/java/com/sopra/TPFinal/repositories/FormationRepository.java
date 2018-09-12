package com.sopra.TPFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPFinal.model.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
	
}