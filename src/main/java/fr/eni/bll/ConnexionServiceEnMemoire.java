package fr.eni.bll;


import fr.eni.dal.MembreRepository;
import fr.eni.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.entities.Membre;

import java.util.Optional;


@Service
public class ConnexionServiceEnMemoire implements ConnexionService {

	@Autowired
	MembreRepository membreRepository;
	
	@Override
	public Membre getMembre(String username, String password) throws BllException {
		Optional<Membre> opt = membreRepository.findFirstByUsernameAndPassword(username, password);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new BllException("Pas de membre trouvé");
		}
	}

}
