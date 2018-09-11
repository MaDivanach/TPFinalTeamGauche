package com.sopra.TPFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPFinal.model.Expertise;
import com.sopra.TPFinal.model.ExpertisePK;

public interface ExpertiseRepository extends JpaRepository<Expertise, ExpertisePK> {

}
