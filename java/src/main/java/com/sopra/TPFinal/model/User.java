package com.sopra.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.view.JsonViews;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seqUser", sequenceName = "seq_user", initialValue = 100, allocationSize = 1)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 20, name = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = Admin.class, name = "admin"),
	@Type(value = Gestionnaire.class, name = "gestionnaire"),
	@Type(value = Stagiaire.class, name = "stagiaire"),
	@Type(value = Technicien.class, name = "technicien"),
	@Type(value = Formateur.class, name = "formateur")
	})
public class User {
	@Id
	@GeneratedValue(generator = "seqUser", strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Column(name = "username", unique = true)
	@JsonView(JsonViews.Common.class)
	private String username;
	@Column(name = "password")
	@JsonView(JsonViews.Common.class)
	private String password;
//	@Column(name = "enable")
//	@JsonView(JsonViews.Common.class)
//	private boolean enable;
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Common.class)
	private Role role;
	@Column(name = "nom")
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Column(name = "prenom")
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@Column(name = "telephone")
	@JsonView(JsonViews.Common.class)
	private String telephone;
	@Version
	private int version;
	@Embedded
	@JsonView(JsonViews.UserWithAdresse.class)
	private Adresse adresse;

	public User() {
		super();
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public boolean isEnable() {
//		return enable;
//	}
//
//	public void setEnable(boolean enable) {
//		this.enable = enable;
//	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return telephone;
	}

	public void setTel(String tel) {
		this.telephone = tel;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
