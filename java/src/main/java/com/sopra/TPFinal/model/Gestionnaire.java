package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("gestionnaire")
public class Gestionnaire extends User {

	public Gestionnaire() {
		super();
		super.setRole(Role.GESTIONNAIRE);
	}

	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.LAZY)
	private Set<Formation> formations;

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
