package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("formateur")
public class Formateur extends User{
	@OneToMany(mappedBy = "key.formateur", fetch = FetchType.LAZY)
	private Set<Expertise> expertises;
	@OneToMany(mappedBy = "key.session", fetch = FetchType.LAZY)
	private Set<Session> sessions;
	
	public Formateur() {
		super();
		super.setRole(Role.FORMATEUR);
	}

	public Set<Expertise> getExpertises() {
		return expertises;
	}

	public void setExpertises(Set<Expertise> expertises) {
		this.expertises = expertises;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	
}
