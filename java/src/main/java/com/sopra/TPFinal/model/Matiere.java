package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.view.JsonViews;

@Entity
@Table(name = "matiere")
@SequenceGenerator(name = "seqMatiere", sequenceName = "seq_matiere", initialValue = 100, allocationSize = 1)
public class Matiere {
	@Id
	@Column(name = "id_matiere")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatiere")
	private Long id;
	@Version
	private int version;
	@Column(name = "titre", length = 50)
	private String titre;
	@Column(name = "objectif", length = 1000)
	private String objectif;
	@Enumerated(EnumType.STRING)
	@Column(name = "prerequis_formateur")
	private Niveau niveau;
	@JsonView(JsonViews.FormateurInMatiere.class)
	@OneToMany(mappedBy = "key.matiere")
	private Set<Expertise> expertises;
	@JsonView(JsonViews.SessionInMatiere.class)
	@OneToMany(mappedBy = "key.matiere")
	private Set<Session> sessions;

	public Matiere() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Expertise> getExpertises() {
		return expertises;
	}

	public void setExpertises(Set<Expertise> formateurs) {
		this.expertises = formateurs;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

}
