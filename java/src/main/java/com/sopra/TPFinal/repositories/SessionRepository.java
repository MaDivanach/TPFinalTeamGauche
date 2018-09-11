package com.sopra.TPFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPFinal.model.Session;
import com.sopra.TPFinal.model.SessionPK;

public interface SessionRepository extends JpaRepository<Session, SessionPK> {

}
