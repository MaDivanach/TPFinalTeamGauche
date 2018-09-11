package com.sopra.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "expertise")
public class Expertise {
	@EmbeddedId
	@Column(name = "key")
	private ExpertisePK key;
	@Version
	private int version;

	public Expertise() {
	}

	public ExpertisePK getExpertisePK() {
		return key;
	}

	public void setExpertisePK(ExpertisePK expertisePK) {
		this.key = expertisePK;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
