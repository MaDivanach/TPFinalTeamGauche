package com.sopra.TPFinal.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.view.JsonViews;

@Entity
@DiscriminatorValue("stagiaire")
public class Stagiaire extends User {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordinateur")
	@JsonView(JsonViews.StagiaireWithDetails.class)
	private Ordinateur ordinateur;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formation")
	@JsonView(JsonViews.StagiaireWithDetails.class)
	private Formation formation;

	public Stagiaire() {
		super();
		super.setRole(Role.STAGIAIRE);
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

}
