package fr.eni.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String avis;

	private int note;

	@ManyToOne
	private Membre auteur;

	public Avis() {
	}

	public Avis(String avis, int note, Membre auteur) {
		this.avis = avis;
		this.note = note;
		this.auteur = auteur;
	}

	public Avis(int id, String avis, int note, Membre auteur) {
		this.id = id;
		this.avis = avis;
		this.note = note;
		this.auteur = auteur;
	}

}
