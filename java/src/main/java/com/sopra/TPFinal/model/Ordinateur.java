package com.sopra.TPFinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="ordinateur")
@SequenceGenerator(name = "seqOrdinateur", sequenceName = "seq_ordinateur", initialValue = 1, allocationSize = 1)
public class Ordinateur extends Materiel {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrdinateur")
	@Column(name="processeur")
	private String processeur;
	
	@Version
	private int version;
	
	@Column(name="ram")
	public String ram;
	
	@Column(name="dd")
	public String dd;
	
	@Column(name="dateAchat")
	private Date dateAchat;
		
	public Ordinateur(Long id, Double coutUtilisation, String processeur, String ram, String dd, Date dateAchat) {
		super(id, coutUtilisation);
		this.processeur = processeur;
		this.ram = ram;
		this.dd = dd;
		this.dateAchat = dateAchat;
	}
	
	public String getCPU() {
		return processeur;
	}
	public void setCPU(String cPU) {
		processeur = cPU;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		ram = ram;
	}
	public String getDD() {
		return dd;
	}
	public void setDD(String dD) {
		dd = dD;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	
}
