package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("salle")
public class Salle extends Materiel {
	@Column(name = "capacite")
	private Integer capacite;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Formation> formations;
	
	public Salle() {
		super();
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

}
