package fr.eni.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Catalogue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany
	private List<Film> films;
	
	public Catalogue() {
	}

	public Catalogue(List<Film> films) {
		this.films = films;
	}

	public Catalogue(int id, List<Film> films) {
		this.id = id;
		this.films = films;
	}
}
