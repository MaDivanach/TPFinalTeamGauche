package com.sopra.TPFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sopra.TPFinal.model.Materiel;

public interface MaterielRepository extends JpaRepository <Materiel, Long> {
	
	
}
