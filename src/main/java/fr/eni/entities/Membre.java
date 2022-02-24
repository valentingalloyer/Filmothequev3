package fr.eni.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Data
@Entity
public class Membre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	@Email
	private String mail;

	private String password;

	boolean admin;

	public Membre() {
	}
	public Membre(String username, String mail, String password, boolean admin) {
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.admin = admin;
	}

	public Membre(int id, String username, String mail, String password, boolean admin) {
		this.id = id;
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.admin = admin;
	}

	public void copy(Membre m) {
		this.id = m.id;
		this.username = m.username;
		this.mail = m.mail;
		this.password = m.password;
		this.admin = m.admin;
	}
	
}
