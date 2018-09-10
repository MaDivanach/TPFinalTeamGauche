package com.sopra.TPFinal.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.view.JsonViews;

@Entity
@Table(name="formation")
public class Formation {

	@Id
	@SequenceGenerator(name = "seqformation", sequenceName = "seq_formation", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "seqformation", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_formation")
	private Long id;
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
	@ManyToOne
	@JoinColumn(name = "id_gestionnaire")
	@JsonView(JsonViews.Common.class)
	private Gestionnaire gestionaire;
	@ManyToOne
	@JoinColumn(name = "id_videoprojecteur")
	@JsonView(JsonViews.Common.class)
	private Videoprojecteur videoprojecteur;
	@ManyToOne
	@JoinColumn(name = "id_Salle")
	@JsonView(JsonViews.Common.class)
	private Salle salle;
	@OneToMany(mappedBy = "formation")
	@JsonView(JsonViews.StagiaireInFormation.class)
	private Set<Stagiaire> stagiaires;
	@OneToMany(mappedBy = "key.formation")
	@JsonView(JsonViews.SessionInFormation.class)
	private Set<Session> sessions;
	@Version
	private int version;

	public Formation() {
		super();
	}

	public Formation(Long id, Date dateDebut, Date dateFin, Gestionnaire gestionaire, Videoprojecteur videoprojecteur,
			Salle salle, Set<Stagiaire> stagiaires, Set<Session> sessions, int version) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.gestionaire = gestionaire;
		this.videoprojecteur = videoprojecteur;
		this.salle = salle;
		this.stagiaires = stagiaires;
		this.sessions = sessions;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Gestionnaire getGestionaire() {
		return gestionaire;
	}

	public void setGestionaire(Gestionnaire gestionaire) {
		this.gestionaire = gestionaire;
	}

	public Videoprojecteur getVideoprojecteur() {
		return videoprojecteur;
	}

	public void setVideoprojecteur(Videoprojecteur videoprojecteur) {
		this.videoprojecteur = videoprojecteur;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
