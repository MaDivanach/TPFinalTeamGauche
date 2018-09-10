package com.sopra.TPFinal.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class MatiereFormateurPK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "id_formateur")
	private Formateur formateur;

	public MatiereFormateurPK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matiere == null) ? 0 : matiere.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatiereFormateurPK other = (MatiereFormateurPK) obj;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		return true;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
