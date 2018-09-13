package com.sopra.TPFinal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPFinal.model.Session;
import com.sopra.TPFinal.model.SessionPK;

public interface SessionRepository extends JpaRepository<Session, SessionPK> {

//	@Query("select s from Session s left join fetch s.formation where f.id_formation=:formation")
//	Optional<Session> FindCustomByIdWithAll(@Param("formation") Long id);
//	
//	@Query("select s from Session s left join fetch s.formation left join fetch s.matiere left join fetch s.formateur")
//	List<Session> SessionAllFormation();
	
}
