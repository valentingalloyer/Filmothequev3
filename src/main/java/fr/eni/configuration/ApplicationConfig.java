package fr.eni.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eni.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ApplicationConfig {

	@Bean
	List<Genre> getGenres(){
		List<Genre> liste = new ArrayList<Genre>();
		liste.add(new Genre(1, "Comédie"));
		liste.add(new Genre(2, "Policier"));
		liste.add(new Genre(3, "Thriller"));
		liste.add(new Genre(4, "Drame"));
		liste.add(new Genre(5, "Comédie dramatique"));
		liste.add(new Genre(6, "Sci-Fi"));
		
		return liste;
	}
	
	@Bean
	Catalogue getCatalogue() {
		Catalogue c = new Catalogue();
		List<Genre> listeG = getGenres();
		
		List<Acteur> acteurs1 = new ArrayList<Acteur>();
		acteurs1.add(new Acteur("Belmondo", "Jean-Paul"));
		acteurs1.add(new Acteur("Anconina", "Richard"));
		acteurs1.add(new Acteur("L.", "Marie-Sophie"));
		Film f1 = new Film(1, "Itinéraire d'un enfant gâté", 
							1988, 
							125, 
							"Après avoir brillamment réussi dans la vie, un homme de cinquante ans se retire secrètement et part à l'aventure.", 
							listeG.get(4), 
							new ArrayList<Avis>(), 
							acteurs1, 
							new Realisateur("Lelouch", "Claude"));
		
		List<Film> listeF = new ArrayList<Film>();
		listeF.add(f1);
		
		
		List<Acteur> acteurs2 = new ArrayList<Acteur>();
		acteurs2.add(new Acteur("Chabat", "Alain"));
		acteurs2.add(new Acteur("Lauby", "Chantal"));
		acteurs2.add(new Acteur("Farrugia", "Dominique"));
		acteurs2.add(new Acteur("Darmon", "Gérard"));
		Film f2 = new Film(2, "La Cité de la peur", 
							1994, 
							119, 
							"Odile Deray, attachée de presse, vient au Festival de Cannes pour présenter le film `Red is Dead'. Malheureusement, celui-ci est d'une telle faiblesse que personne ne souhaite en faire l'écho. Cependant, lorsque les projectionnistes du long-métrage en question meurent chacun leur tour dans d'étrange ...", 
							listeG.get(0), 
							new ArrayList<Avis>(), 
							acteurs2, 
							new Realisateur("Berberian", "Alain"));
		
		listeF.add(f2);
		c.setFilms(listeF);
		return c;
	}

	@Bean
	List<Membre> membres(){
		List<Membre> liste = new ArrayList<Membre>();
		liste.add(new Membre(1, "user", "user@mail.com", "user", false));
		liste.add(new Membre(2, "admin", "admin@mail.com", "admin", true));
		return liste;
	}

	@Bean
	@SessionScope()
	Membre membre(){
		return new Membre();
	}

}
