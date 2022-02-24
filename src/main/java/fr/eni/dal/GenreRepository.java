package fr.eni.dal;

import fr.eni.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Genre findFirstByLibelle(String libelle);

}
