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
import tn.sportun.repositories.PublicationRepository;
import tn.sportun.services.PublicationService;

@RestController
@RequestMapping(value = "publication")
public class PublicationEndpoint {

	@Autowired
	PublicationService  publicationService  ; 
	
	@RequestMapping(value = ""  , method=RequestMethod.GET) 
	public List<Publication> findAll () { 
		return publicationService.findAll();
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Optional<Publication> findall(@PathVariable("id") Integer id) {
		return publicationService.findById(id); 
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public void deletebyid (@PathVariable("id") Integer id) {
		publicationService.deleteById(id); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public void save (@RequestBody Publication publication) {
		publicationService.save(publication); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public void edit (@RequestBody Publication publication) {
		publicationService.save( publication); 
	}
	
}
