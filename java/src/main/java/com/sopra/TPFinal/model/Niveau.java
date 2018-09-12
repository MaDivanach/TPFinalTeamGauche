package com.sopra.TPFinal.model;

public enum Niveau {
	DEBUTANT(0), INTERMEDIAIRE(1), AVANCE(2), EXPERT(3);

	private Integer niveau;

	private Niveau(Integer niveau) {
		this.niveau = niveau;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

}