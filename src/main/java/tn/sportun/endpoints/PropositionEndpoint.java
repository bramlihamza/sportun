package tn.sportun.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.sportun.entities.Proposition;
import tn.sportun.entities.Publication;
import tn.sportun.repositories.PropositionRepository;
import tn.sportun.services.PropositionService;

@RestController
@RequestMapping(value="/*proposition")
public class PropositionEndpoint {

	@Autowired
	PropositionService propositionService ;
	
	
	@RequestMapping (value="" , method=RequestMethod.GET) 
	public List<Proposition> FindAll () { 
		return propositionService.findAll() ;
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Optional<Proposition> findall(@PathVariable("id") Integer id) {
		return propositionService.findById(id); 
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public void deletebyid (@PathVariable("id") Integer id) {
		propositionService.deleteById(id); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public void save (@RequestBody Proposition publication) {
		propositionService.save(publication); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public void edit (@RequestBody Proposition publication) {
		propositionService.save(publication); 
	}
	
}
