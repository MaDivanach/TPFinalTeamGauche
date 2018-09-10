package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "matiere_prerequis")
public class Prerequis {

	@Column(name = "")
	private Set<Matiere> listeMatiere;

	public Prerequis() {
	}

}
