package com.sopra.TPFinal.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.view.JsonViews;

@Entity
@Table(name = "matiere")
@SequenceGenerator(name = "seqMatiere", sequenceName = "seq_matiere", initialValue = 1, allocationSize = 1)
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
	private Set<MatiereFormateur> formateurs;
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

	public Set<MatiereFormateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Set<MatiereFormateur> formateurs) {
		this.formateurs = formateurs;
	}

}
