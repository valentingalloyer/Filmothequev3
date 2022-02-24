package fr.eni.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	public Genre() {
	}

	public Genre(String libelle) {
		this.libelle = libelle;
	}

	public Genre(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

}
