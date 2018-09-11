package com.sopra.TPFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPFinal.model.MatiereFormateur;
import com.sopra.TPFinal.model.MatiereFormateurPK;

public interface MatiereFormateurRepository extends JpaRepository<MatiereFormateur, MatiereFormateurPK> {

}
