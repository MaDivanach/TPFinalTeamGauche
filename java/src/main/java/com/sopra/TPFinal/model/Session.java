package com.sopra.TPFinal.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "session")
@SequenceGenerator(name = "seqSession", sequenceName = "seq_session", initialValue = 1, allocationSize = 1)
public class Session {
	@EmbeddedId
	private SessionPK key;

	private Date dateDebut;
	private Date dateFin;

	public SessionPK getKey() {
		return key;
	}

	public void setKey(SessionPK key) {
		this.key = key;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
