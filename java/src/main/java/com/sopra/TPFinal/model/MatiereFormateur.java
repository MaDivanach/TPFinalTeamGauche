package com.sopra.TPFinal.model;

import javax.persistence.*;

@Entity
@Table(name = "matiere_formateur")
public class MatiereFormateur {
	@EmbeddedId
	private MatiereFormateurPK key;

	public MatiereFormateurPK getKey() {
		return key;
	}

	public void setKey(MatiereFormateurPK key) {
		this.key = key;
	}

}
