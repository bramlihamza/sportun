package tn.sportun.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Reponse {
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer idReponse;
	private boolean rsponse_content  = false ; 
	private boolean accord = false ; 
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	 @JsonIdentityInfo(
			  generator = ObjectIdGenerators.StringIdGenerator.class,
			  property="reponsePublication")
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "idPublication", nullable = false)
	private Publication publciation ;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "user_id", referencedColumnName = "idUser")
	private User user ; 

	public Integer getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(Integer idReponse) {
		this.idReponse = idReponse;
	}

	public boolean isRsponse_content() {
		return rsponse_content;
	}

	public void setRsponse_content(boolean rsponse_content) {
		this.rsponse_content = rsponse_content;
	}

	public boolean isAccord() {
		return accord;
	}

	public void setAccord(boolean accord) {
		this.accord = accord;
	}

	public Publication getPublciation() {
		return publciation;
	}

	public void setPublciation(Publication publciation) {
		this.publciation = publciation;
	}

	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reponse [idReponse=" + idReponse + ", rsponse_content=" + rsponse_content + ", accord=" + accord
				+ ", publciation=" + publciation + "]";
	} 
	 
	 
	 
	 
}
