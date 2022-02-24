package fr.eni.bll;

import java.util.List;

import fr.eni.entities.Avis;
import fr.eni.entities.Film;
import fr.eni.entities.Genre;

public interface FilmService {

	Film trouverFilm(int id) throws BllException;
	List<Film> listerFilms();
	List<Genre> listerGenres();
	void ajouterFilm(Film f) throws BllException;
	void ajouterAvis(int idFilm, Avis av) throws BllException;
}
