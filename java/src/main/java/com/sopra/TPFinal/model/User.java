package com.sopra.TPFinal.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(name="username")
	private String username;
	@JoinColumn(name="password")
	private String password;
	private boolean enable;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Role role;
	@JoinColumn(name="name")
	private String nom;
	@JoinColumn(name="firstname")
	private String prenom;
	@JoinColumn(name="telephonenumber")
	private String tel;
	
	public User() {
		super();
	}

	public User(Integer id, String username, String password, boolean enable, Role role, String nom, String prenom,
			String tel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	
	

	public User(Role role) {
		super();
		this.role = role;
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
}
