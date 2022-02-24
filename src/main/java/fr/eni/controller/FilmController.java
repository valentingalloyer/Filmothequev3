package fr.eni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.bll.BllException;
import fr.eni.bll.FilmService;
import fr.eni.entities.Avis;
import fr.eni.entities.Film;
import fr.eni.entities.Membre;

import javax.validation.Valid;

@Controller
public class FilmController {

    @Autowired
    Membre membre;

    @Autowired
    private FilmService filmService;

    @GetMapping({"/", "/index"})
    String accueil(@ModelAttribute String message) {
        return "index";
    }

    @GetMapping("/lister")
    String lister(Model model) {
        model.addAttribute("listeF", filmService.listerFilms());
        return "listefilms";
    }


    @GetMapping("/afficher")
    String afficher(Integer id, Model model) throws BllException {
        String retour = "fichefilm";
        Film f = filmService.trouverFilm(id);
        if (f == null) {
            model.addAttribute("erreur", "Aucun film ne correspond à l'id " + id);
            model.addAttribute("listeF", filmService.listerFilms());
            retour = "listefilms";
        } else {
            model.addAttribute("film", f);
        }
        return retour;
    }


    @GetMapping("/ajouter")
    String ajouter(Model model) {
        if (!membre.isAdmin()) {
            model.addAttribute("erreur", "Vous devez être admin pour ajouter un film");
            return "index";
        }
        model.addAttribute("listeG", filmService.listerGenres());
        model.addAttribute("film", new Film());

        return "ajoutfilm";
    }

    @PostMapping("/ajouter")
    String ajouterPost(Model model, @Valid Film film, BindingResult br) {
        if (!br.hasErrors()) {
            System.out.println(film);
            try {
                filmService.ajouterFilm(film);
            } catch (BllException e) {
                model.addAttribute("listeG", filmService.listerGenres());
                model.addAttribute("film", film);
                model.addAttribute("erreur", e.getMessage());
                return "ajoutfilm";
            }

            return "redirect:/lister";

        } else {
            System.out.println("Valid a échoué");
            model.addAttribute("film", film);
            model.addAttribute("listeG", filmService.listerGenres());
            return "ajoutfilm";
        }
    }

    @GetMapping("/modifier/{id}")
    String modifierFilm(Model model, @PathVariable int id) throws BllException {
        if (!membre.isAdmin()) {
            model.addAttribute("erreur", "Vous devez être admin pour modifier un film");
            return "index";
        }
        model.addAttribute("listeG", filmService.listerGenres());
        Film film = filmService.trouverFilm(id);
        System.out.println(film);
        model.addAttribute("film", film);

        return "modifFilm";
    }

    @PostMapping("/modifier/{id}")
    String modifierFilmPost(Model model, @PathVariable int id, @Valid @ModelAttribute Film film, BindingResult br) {
        if (!br.hasErrors()) {

            System.out.println(film);
            try {
                filmService.modifierFilm(film);
            } catch (BllException e) {
                model.addAttribute("listeG", filmService.listerGenres());
                model.addAttribute("film", film);
                model.addAttribute("erreur", e.getMessage());
                return "modifFilm";
            }
            return "redirect:/lister";

        } else {
            System.out.println("Valid a échoué");
            model.addAttribute("film", film);
            return "modiffilm";
        }
    }

    @GetMapping("/supprimer/{id}")
    String supprimer(Model model, @PathVariable int id) throws BllException {
        System.out.println(id);
        try {
            filmService.supprimerFilm(id);
        } catch (BllException e) {
            model.addAttribute("film", filmService.trouverFilm(id));
            model.addAttribute("erreur", e.getMessage());
            return "ajoutfilm";
        }

        return "redirect:/lister";
    }

    @GetMapping("/ajouteravis/{id}")
    String ajouterAvis(@PathVariable Integer id, Model model) throws BllException {
        Film f = filmService.trouverFilm(id);
        if (f == null) {
            return "redirect:/lister";
        }

        model.addAttribute("film", f);
        model.addAttribute("avis", new Avis());

        return "ajoutavis";
    }

    @PostMapping("/ajouteravis/{id}")
    String ajouterAvisPost(@PathVariable Integer id, Model model, @ModelAttribute("avis") Avis avis) throws BllException {
        Film f = filmService.trouverFilm(id);
        if (f == null) {
            return "redirect:/lister";
        }

        filmService.ajouterAvis(id, avis);

        return "redirect:/lister";
    }

}
