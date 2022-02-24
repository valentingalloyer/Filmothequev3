package fr.eni.dal;

import fr.eni.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Integer> {


}
