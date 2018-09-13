package com.sopra.TPFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPFinal.model.Session;
import com.sopra.TPFinal.model.SessionPK;

public interface SessionRepository extends JpaRepository<Session, SessionPK> {
//	
//	@Query("select s from Session s left join fetch s.formation where f.id_formation=:formation")
//	Optional<Session> SessionInFormation(@Param("id_formation") Long id);
}
