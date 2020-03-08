package tn.sportun.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("proposition")
public class Proposition extends Publication {

	public Proposition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proposition(Integer idPublication, String specialite, String description, String publicationPublic,
			List<File> files) {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
