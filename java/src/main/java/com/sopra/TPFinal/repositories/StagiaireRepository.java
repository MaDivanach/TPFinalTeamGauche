package com.sopra.TPFinal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPFinal.model.Stagiaire;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
	
//	@Query("select s from stagiaire s left join fetch s.formation where f.id_formation=:formation")
//	Optional<Stagiaire> StagiaireInFormation(@Param("id_formation") Long id);

}
