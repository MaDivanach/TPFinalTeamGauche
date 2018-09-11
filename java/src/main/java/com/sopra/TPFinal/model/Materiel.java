package com.sopra.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="materiel")
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_materiel", initialValue = 1, allocationSize = 1)
public abstract class Materiel {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMateriel")
	@Id
	@Version
	private int version;
	@Column(name="id")
	private Long id;
	
	@Column(name="coutUtilisation")
	private Double coutUtilisation;
	
	@Column(name="salle")
	private Salle salle;
	
	@Column(name="ordinateur")
	private Ordinateur ordinateur;
	
	@Column(name="videoProjecteur")
	private VideoProjecteur videoProjecteur;
	
	
	
	public Materiel(Long id, Double coutUtilisation) {
		super();
		this.id = id;
		this.coutUtilisation = coutUtilisation;
	}

	

	public Materiel(Long id, Double coutUtilisation, Salle salle) {
		super();
		this.id = id;
		this.coutUtilisation = coutUtilisation;
		this.salle = salle;
	}

	

	public Materiel(Long id, Double coutUtilisation, Ordinateur ordinateur) {
		super();
		this.id = id;
		this.coutUtilisation = coutUtilisation;
		this.ordinateur = ordinateur;
	}

	public Materiel(Long id, Double coutUtilisation, VideoProjecteur videoProjecteur) {
		super();
		this.id = id;
		this.coutUtilisation = coutUtilisation;
		this.videoProjecteur = videoProjecteur;
	}



	public boolean disponibilite() {
		
		
		return false;	
	}
	
	

	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getCoutUtilisation() {
		return coutUtilisation;
	}



	public void setCoutUtilisation(Double coutUtilisation) {
		this.coutUtilisation = coutUtilisation;
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
		Materiel other = (Materiel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
