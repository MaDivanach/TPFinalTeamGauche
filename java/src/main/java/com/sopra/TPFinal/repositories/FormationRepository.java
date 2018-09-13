package com.sopra.TPFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPFinal.model.Formation;
import com.sopra.TPFinal.model.Session;
import com.sopra.TPFinal.model.Stagiaire;

public interface FormationRepository extends JpaRepository<Formation, Long> {
	
	@Query("select f from Formation f left join fetch f.stagiaire where f.id_formation=:formation")
	Optional<Stagiaire> FindCustomByIdWithAll(@Param("formation") Long id);
	
}