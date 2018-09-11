package com.sopra.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.view.JsonViews;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seqUser", sequenceName = "seq_user", initialValue = 100, allocationSize = 1)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 20, name = "type")
public class User {
	@Id
	@GeneratedValue(generator = "seqUser", strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Column(name = "username")
	@JsonView(JsonViews.Common.class)
	private String username;
	@Column(name = "password")
	@JsonView(JsonViews.Common.class)
	private String password;
	@Column(name = "enable")
	@JsonView(JsonViews.Common.class)
	private boolean enable;
	//@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Common.class)
	private Role role;
	@Column(name = "name")
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Column(name = "firstname")
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@Column(name = "telephonenumber")
	@JsonView(JsonViews.Common.class)
	private String tel;
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

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
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
