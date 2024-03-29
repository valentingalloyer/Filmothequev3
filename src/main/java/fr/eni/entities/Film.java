package fr.eni.entities;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Le titre est obligatoire")
	private String titre;

	@Min(1900)
	@Max(2022)
	private int annee;

	@Min(10)
	@Max(300)
	private int duree;

	@Lob
	private String synopsis;

	@ManyToOne
	private Genre genre;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Avis> listeAvis;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Acteur> acteurs;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Realisateur realisateur;

	public Film() {
		setDuree(100);
		setAnnee(2000);
		setListeAvis(null);
		setActeurs(null);
	}
	public Film(String titre, int annee, int duree, String synopsis, Genre genre, List<Avis> listeAvis,
			List<Acteur> acteurs, Realisateur realisateur) {
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
			List<Acteur> acteurs, Realisateur realisateur) {
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
