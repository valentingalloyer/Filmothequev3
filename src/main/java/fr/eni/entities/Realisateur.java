package fr.eni.entities;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Realisateur extends Personne {
    public Realisateur(String nom, String prenom) {
        super();
    }

    public Realisateur(int id, String nom, String prenom) {
        super(id, nom, prenom);
    }

    public Realisateur() {
    }
}
