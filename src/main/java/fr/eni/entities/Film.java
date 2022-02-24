package fr.eni.entities;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String titre;

	private int annee;

	private int duree;

	@Lob
	private String synopsis;

	@ManyToOne
	private Genre genre;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Avis> listeAvis;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Personne> acteurs;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Personne realisateur;

	public Film() {
		setAnnee(2000);
		
		setListeAvis(null);
		setActeurs(null);
	}
	public Film(String titre, int annee, int duree, String synopsis, Genre genre, List<Avis> listeAvis,
			List<Personne> acteurs, Personne realisateur) {
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.genre = genre;
		setListeAvis(listeAvis);
		setActeurs(acteurs);
		this.realisateur = realisateur;
	}

	public Film(int id, String titre, int annee, int duree, String synopsis, Genre genre, List<Avis> listeAvis,
			List<Personne> acteurs, Personne realisateur) {
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.genre = genre;
		setListeAvis(listeAvis);
		setActeurs(acteurs);
		this.realisateur = realisateur;
	}
}
