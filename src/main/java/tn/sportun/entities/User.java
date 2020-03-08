package tn.sportun.entities;

import java.util.Collection;
import java.util.Date;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "User")
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_UTILISATEUR")
	private int idUser ; 
    
	private String nom ; 
	private String prenom ;
	private String email ;
	private String password ;
	private Date dateNaissance ; 
	private String ville; 
	private String status ; 
	private String specialite ; 
	private String niveau ; 
	
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="UserFile")
    @OneToOne 
    @JoinColumn(name="fileId") 
	private File photo ;
	
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="idUserPublication")
	 
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "user")
	private List<Publication> listPublication ;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getIdUser() {
		return idUser;
	}




	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public Date getDateNaissance() {
		return dateNaissance;
	}




	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}




	public String getVille() {
		return ville;
	}




	public void setVille(String ville) {
		this.ville = ville;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getSpecialite() {
		return specialite;
	}




	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}




	public String getNiveau() {
		return niveau;
	}




	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}




	public File getPhoto() {
		return photo;
	}




	public void setPhoto(File photo) {
		this.photo = photo;
	}




	public Collection<Publication> getListPublication() {
		return listPublication;
	}




	public void setListPublication(List<Publication> listPublication) {
		this.listPublication = listPublication;
	}




	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", ville=" + ville + ", status=" + status + ", specialite=" + specialite + ", niveau=" + niveau
				+ ", photo=" + photo + ", listPublication=" + listPublication + "]";
	} 
	
	
	
	
	
}
