package com.sopra.TPFinal.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.view.JsonViews;

@Entity
@Table(name = "session")
@SequenceGenerator(name = "seqSession", sequenceName = "seq_session", initialValue = 100, allocationSize = 1)
public class Session {
	@EmbeddedId
	private SessionPK key;
	@Version
	private int version;
	@Column(name = "date_debut")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private Date dateDebut;
	@Column(name = "date_fin")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private Date dateFin;

	public Session() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Session other = (Session) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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
