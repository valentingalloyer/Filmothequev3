package fr.eni.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	private String prenom;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

}
