package fr.eni.dal;

import fr.eni.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}
