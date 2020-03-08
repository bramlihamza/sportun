package tn.sportun.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("demande")
public class Demande extends Publication {

	
	private Boolean urgent ;

	public Demande(Integer idPublication, String specialite, String description, String publicationPublic,
			List<File> files, Boolean urgent) {
		super();
		this.urgent = urgent;
	}



	public Demande(Integer idPublication, String specialite, String description, String publicationPublic,
			List<File> files) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demande() {
		super();
	}



	public Boolean getUrgent() {
		return urgent;
	}



	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	} 
	
	
	
	
	
}
