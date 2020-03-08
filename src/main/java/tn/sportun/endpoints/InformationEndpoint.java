package tn.sportun.endpoints;

import java.util.List;
import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.sportun.entities.Information;
import tn.sportun.entities.Proposition;
import tn.sportun.repositories.InformationRepository;
import tn.sportun.services.InformationService;

@RestController
@RequestMapping(value="information")
public class InformationEndpoint {
	
	@Autowired
	InformationService informationService ; 
	
	@RequestMapping(value="" , method=RequestMethod.GET) 
	public List<Information> findAll () { 
		return informationService.findAll() ; 
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Optional<Information> findall(@PathVariable("id") Integer id) {
		return informationService.findById(id); 
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public void deletebyid (@PathVariable("id") Integer id) {
		informationService.deleteById(id); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public void save (@RequestBody Information publication) {
		informationService.save(publication); 	 
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public void edit (@RequestBody Information publication) {
		informationService.save(publication); 
	}
}
