package com.sopra.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Salle")
@SequenceGenerator(name = "seqSalle", sequenceName = "seq_salle", initialValue = 1, allocationSize = 1)
public class Salle extends Materiel{
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSalle")
	@Column(name="capacite")
	@Version
	private int version;
	private Integer capacite;

	
	public Salle(Long id, Double coutUtilisation, Integer capacite) {
		super(id, coutUtilisation);
		this.capacite = capacite;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	
	
	
}
