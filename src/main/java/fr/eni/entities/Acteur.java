package fr.eni.entities;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Acteur extends Personne {
    public Acteur(String nom, String prenom) {
        super();
    }

    public Acteur(int id, String nom, String prenom) {
        super(id, nom, prenom);
    }

    public Acteur() {
    }
}
