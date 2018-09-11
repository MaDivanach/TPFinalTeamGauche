package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("videoprojecteur")
public class VideoProjecteur extends Materiel {
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Formation> formations;

	public VideoProjecteur() {
		super();
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
