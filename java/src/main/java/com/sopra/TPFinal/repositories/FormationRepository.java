package com.sopra.TPFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPFinal.model.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
//	@Query("select f from Formation f left join fetch f.stagiaires where f.id = :id_formation")
//	Optional<Formation> StagiaireInFormation(@Param("id_formation") Long id);
//
//	@Query("select f from Formation f left join fetch f.sessios where f.id = :id_formation")
//	Optional<Formation> SessionInFormation(@Param("id_formation") Long id);

}