package com.sopra.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "materiel")
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_materiel", initialValue = 100, allocationSize = 1)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 20, name = "type")
public abstract class Materiel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMateriel")
	@Column(name = "id")
	private Long id;
	@Version
	private int version;
	@Column(name = "coutUtilisation")
	private Double coutUtilisation;

	public Materiel() {
	}

	public Materiel(Long id, int version, Double coutUtilisation) {
		this.id = id;
		this.version = version;
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

}
