package com.sopra.TPFinal.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

	public Admin() {
		super();
		super.setRole(Role.ADMIN);
	}

	
}
