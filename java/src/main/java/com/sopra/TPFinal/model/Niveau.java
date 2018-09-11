package com.sopra.TPFinal.model;

public enum Niveau {
	DEBUTANT(1), INTERMEDIAIRE(2), AVANCE(3), EXPERT(4);

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
