package fr.eni;

import fr.eni.dal.FilmRepository;
import fr.eni.dal.GenreRepository;
import fr.eni.dal.MembreRepository;
import fr.eni.dal.PersonneRepository;
import fr.eni.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Filmothequev3Application implements CommandLineRunner {

	@Autowired
	GenreRepository genreRepository;

	@Autowired
	MembreRepository membreRepository;

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	PersonneRepository personneRepository;

	public static void main(String[] args) {
		SpringApplication.run(Filmothequev3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/** Liste des genres */
		Genre g1 = new Genre(1, "Comédie");
		Genre g2 = new Genre(2, "Policier");
		Genre g3 = new Genre(3, "Thriller");
		Genre g4 = new Genre(4, "Drame");
		Genre g5 = new Genre(5, "Comédie dramatique");
		Genre g6 = new Genre(6, "Sci-Fi");
		genreRepository.save(g1);
		genreRepository.save(g2);
		genreRepository.save(g3);
		genreRepository.save(g4);
		genreRepository.save(g5);
		genreRepository.save(g6);

		List<Personne> acteurs1 = new ArrayList<Personne>();
		Personne a1 = new Personne("Belmondo", "Jean-Paul");
		Personne a2 = new Personne("Anconina", "Richard");
		Personne a3 = new Personne("Belmondo", "Jean-Paul");
//		personneRepository.save(a1);
//		personneRepository.save(a2);
//		personneRepository.save(a3);
		acteurs1.add(a1);
		acteurs1.add(a2);
		acteurs1.add(a3);

		Personne r1 = new Personne("Lelouch", "Claude");
//		personneRepository.save(r1);
		Film f1 = new Film("Itinéraire d'un enfant gâté",
				1988,
				125,
				"Après avoir brillamment réussi dans la vie, un homme de cinquante ans se retire secrètement et part à l'aventure.",
				genreRepository.findFirstByLibelle("Drame"),
				new ArrayList<Avis>(),
				acteurs1,
				r1);

		filmRepository.save(f1);


		List<Personne> acteurs2 = new ArrayList<Personne>();
		Personne a11 = new Personne("Chabat", "Alain");
		Personne a12 = new Personne("Lauby", "Chantal");
		Personne a13 = new Personne("Farrugia", "Dominique-Paul");
		Personne a14 = new Personne("Darmon", "Gérard");
//		personneRepository.save(a11);
//		personneRepository.save(a12);
//		personneRepository.save(a13);
//		personneRepository.save(a14);
		acteurs2.add(a11);
		acteurs2.add(a12);
		acteurs2.add(a13);
		acteurs2.add(a14);
//		acteurs2.add(a1);
		Personne r2 = new Personne("Berberian", "Alain");
//		personneRepository.save(r2);
		Film f2 = new Film("La Cité de la peur",
				1994,
				119,
				"Odile Deray, attachée de presse, vient au Festival de Cannes pour présenter le film `Red is Dead'. Malheureusement, celui-ci est d'une telle faiblesse que personne ne souhaite en faire l'écho. Cependant, lorsque les projectionnistes du long-métrage en question meurent chacun leur tour dans d'étrange ...",
				genreRepository.findFirstByLibelle("Comédie"),
				new ArrayList<Avis>(),
				acteurs2,
				r2);
		filmRepository.save(f2);
	}
}
