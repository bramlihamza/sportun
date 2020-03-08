package tn.sportun.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.sportun.entities.Publication;
import tn.sportun.entities.Reponse;
import tn.sportun.entities.User;
import tn.sportun.repositories.UserRepository;
import tn.sportun.services.PublicationService;
import tn.sportun.services.ReponseService;

@RestController
@RequestMapping(value = "/reponse")
public class ReponseEndpoint {

	@Autowired
	ReponseService reponseService ; 
	@Autowired
	PublicationService publicationService ; 
	@Autowired
	UserRepository userRepository ; 
	
	@RequestMapping(value = ""  , method=RequestMethod.GET) 
	public List<Reponse> findAll () { 
		return reponseService.findAll();
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Optional<Reponse> findall(@PathVariable("id") Integer id) {
		return reponseService.findById(id); 
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public void deletebyid (@PathVariable("id") Integer id) {
		reponseService.deleteById(id); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public void save (@RequestBody Reponse reponse) {
		reponseService.save(reponse); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public void edit (@RequestBody Reponse reponse) {
		reponseService.save( reponse); 
	}
	
	@RequestMapping(value="/repondre/{idpublication}/{iduser}",method=RequestMethod.POST)
	public void repondre (@PathVariable("idpublication") Integer idpublication  ,
			@PathVariable("iduser") Integer iduser
			) {
		Reponse reponse = new Reponse();
		Publication  publication = publicationService.findById(idpublication).get() ; 
		User user = userRepository.findById(iduser).get();
		
		reponse.setRsponse_content(true);
		reponse.setPublciation(publication);
		reponse.setUser(user);
		reponseService.save(reponse); 	 
		publication.getReponses().add(reponse) ; 
		publicationService.save(publication) ;
	}
	
	@RequestMapping(value="/accord/{idreponse}",method=RequestMethod.PUT)
	public void accord (@PathVariable("idreponse") Integer idreponse) {
		
		Reponse  reponse = reponseService.findById(idreponse).get() ; 
		reponse.setAccord(true);
		reponseService.save(reponse); 	 
		
	}
}
