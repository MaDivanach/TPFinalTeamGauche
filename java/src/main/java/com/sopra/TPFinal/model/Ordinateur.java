package com.sopra.TPFinal.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ordinateur")
public class Ordinateur extends Materiel {
	@Column(name = "processeur")
	private String processeur;
	@Column(name = "ram")
	public String ram;
	@Column(name = "dd")
	public String dd;
	@Column(name = "dateAchat")
	private Date dateAchat;
	@OneToMany(mappedBy = "ordinateur", fetch = FetchType.LAZY)
	private Set<Stagiaire> stagiaires;

	public Ordinateur() {
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

}
