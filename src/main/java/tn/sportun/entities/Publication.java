package tn.sportun.entities;

import java.util.Collection;
import java.util.List;


import javax.persistence.CascadeType;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="publication_type")
public class Publication {
	 @Id
	 @GeneratedValue
	private int idPublication ;
	private String specialite ; 
	private String description ; 
	private String publicationPublic ;

	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="idPublicationfiles")
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "publicationFile") 
	private List<File>  files ;

	
	 //@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="idPublicationUser")
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "idUser", nullable = false)
	private User user ;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="publicationReponse")
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "publciation")
	private List <Reponse> reponses ;


	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getIdPublication() {
		return idPublication;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	


	public List<Reponse> getReponses() {
		return reponses;
	}


	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}


	public void setIdPublication(int idPublication) {
		this.idPublication = idPublication;
	}


	public void setIdPublication(Integer idPublication) {
		this.idPublication = idPublication;
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPublicationPublic() {
		return publicationPublic;
	}


	public void setPublicationPublic(String publicationPublic) {
		this.publicationPublic = publicationPublic;
	}


	public List<File> getFiles() {
		return files;
	}


	public void setFiles(List<File> files) {
		this.files = files;
	}


	@Override
	public String toString() {
		return "Publication [idPublication=" + idPublication + ", specialite=" + specialite + ", description="
				+ description + ", publicationPublic=" + publicationPublic + ", files=" + files + "]";
	} 
	
	
	
	
	
	
}
