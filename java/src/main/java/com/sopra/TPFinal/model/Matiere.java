package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "matiere")
@SequenceGenerator(name = "seqMatiere", sequenceName = "seq_matiere", initialValue = 1, allocationSize = 1)
public class Matiere {
	@Id
	@Column(name = "id_matiere")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatiere")
	private Long id;
	@Column(name = "titre", length = 50)
	private String titre;
	@Column(name = "objectif", length = 1000)
	private String objectif;
	@Enumerated(EnumType.STRING)
	@Column(name = "prerequis_formateur")
	private Niveau niveau;
	@OneToMany(mappedBy = "key.matiere")
	private Set<MatiereFormateur> formateurs;

	public Matiere() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formateurs == null) ? 0 : formateurs.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((objectif == null) ? 0 : objectif.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Matiere other = (Matiere) obj;
		if (formateurs == null) {
			if (other.formateurs != null)
				return false;
		} else if (!formateurs.equals(other.formateurs))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (niveau != other.niveau)
			return false;
		if (objectif == null) {
			if (other.objectif != null)
				return false;
		} else if (!objectif.equals(other.objectif))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Set<MatiereFormateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Set<MatiereFormateur> formateurs) {
		this.formateurs = formateurs;
	}

	
}
