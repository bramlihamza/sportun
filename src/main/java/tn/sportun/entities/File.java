package tn.sportun.entities;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
public class File {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_UTILISATEUR")
	
	private Integer idFile ; 
	private String fileName ; 
	private String extension ;
	private String url ;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="idFileUser")
	@OneToOne(mappedBy="photo")
	private User user ; 
	
	
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="filepublication")
	 
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPublication", nullable = false)
	private Publication publicationFile ; 
	
 

	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPublication() {
		return publicationFile;
	}
	public void setPublication(Publication publication) {
		this.publicationFile = publication;
	}
	public Integer getIdFile() {
		return idFile;
	}
	public void setIdFile(Integer idFile) {
		this.idFile = idFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "File [idFile=" + idFile + ", fileName=" + fileName + ", extension=" + extension + ", url=" + url + "]";
	} 
	
	
	
}
