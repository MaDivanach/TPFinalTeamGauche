package com.sopra.TPFinal.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("technicien")
public class Technicien extends User{
	
	public Technicien() {
		super();
		super.setRole(Role.TECHNICIEN);
	}
}
