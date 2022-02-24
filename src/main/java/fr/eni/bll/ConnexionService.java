package fr.eni.bll;

import fr.eni.entities.Membre;

public interface ConnexionService {

	Membre getMembre(String username, String password);
}
