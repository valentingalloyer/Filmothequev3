package fr.eni.dal;

import fr.eni.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembreRepository extends JpaRepository<Membre, Integer> {

    Optional<Membre> findFirstByUsernameAndPassword(String username, String password);

}
