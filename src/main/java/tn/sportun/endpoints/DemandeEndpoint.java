package tn.sportun.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.sportun.entities.Demande;

import tn.sportun.services.DemandeService;

@RestController
@RequestMapping(value="/demande")
public class DemandeEndpoint {

	@Autowired
	DemandeService demandeService ; 
	
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Demande> findAll () {
		return demandeService.findAll() ;
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Optional<Demande> findall(@PathVariable("id") Integer id) {
		return demandeService.findById(id); 
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public void deletebyid (@PathVariable("id") Integer id) {
		demandeService.deleteById(id); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public void save (@RequestBody Demande publication) {
		demandeService.save(publication); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public void edit (@RequestBody Demande publication) {
		demandeService.save(publication); 
	}
}
