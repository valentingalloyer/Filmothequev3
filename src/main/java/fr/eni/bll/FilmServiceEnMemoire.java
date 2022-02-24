package fr.eni.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.dal.FilmRepository;
import fr.eni.dal.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.entities.Avis;
import fr.eni.entities.Catalogue;
import fr.eni.entities.Film;
import fr.eni.entities.Genre;
import fr.eni.entities.Membre;

@Service
public class FilmServiceEnMemoire implements FilmService{

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	private ConnexionService connexionService;

	@Override
	public Film trouverFilm(int id) throws BllException {
		Optional<Film> opt = filmRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new BllException("Pas de livre trouvé");
		}
	}

	@Override
	public List<Film> listerFilms() {
		return filmRepository.findAll();
	}

	@Override
	public List<Genre> listerGenres() {
		return genreRepository.findAll();
	}

	@Override
	public void ajouterFilm(Film f) throws BllException {
		if (f == null) {
			throw new BllException("Le film est null");
		} else {
			if (f.getTitre() == null || f.getTitre().trim().isEmpty()) {
				throw new BllException("Le titre est obligatoire");
			}
			if (f.getRealisateur() == null || f.getRealisateur().getNom() == null || f.getRealisateur().getNom().isEmpty()) {
				throw new BllException("Le nom du réalisateur est obligatoire");
			}
			
			// trouver le genre
			Genre g = trouverGenre(f.getGenre().getId());
			if (g == null) {
				throw new BllException("Le genre est obligatoire");
			}
			else {
				f.setGenre(g);
			}
		}
		filmRepository.save(f);
	}

	@Override
	public void ajouterAvis(int idFilm, Avis av) throws BllException {
		Film f = trouverFilm(idFilm);
		if (f != null) {
//			av.setAuteur(connexionService.getMembre(membre.getUsername(), membre.getPassword())); TODO
			f.getListeAvis().add(av);
		}
	}

	private Genre trouverGenre(int id) throws BllException {
		Optional<Genre> opt = genreRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new BllException("Pas de genre trouvé");
		}
	}
}
