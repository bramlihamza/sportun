package tn.sportun.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("information")
public class Information extends Publication {

	private String type ;

	public Information(Integer idPublication, String specialite, String description, String publicationPublic,
			List<File> files, String type) {
		super();
		this.type = type;
	}

	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Information(Integer idPublication, String specialite, String description, String publicationPublic,
			List<File> files) {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	} 
	
	
}
