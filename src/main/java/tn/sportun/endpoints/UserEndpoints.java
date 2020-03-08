package tn.sportun.endpoints;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.sportun.entities.File;
import tn.sportun.entities.User;
import tn.sportun.fileStorage.FIleControllerDB;
import tn.sportun.fileStorage.FileStorageService;
import tn.sportun.fileStorage.UploadFileResponse;
import tn.sportun.services.UserService;




@RestController
@RequestMapping(value = "/user")
public class UserEndpoints {

	@Autowired
	UserService userService ;
	
	 @Autowired
	 private FIleControllerDB fileController ;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<User> findAllUsers () { 
		return userService.findAll();
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findAll(@PathVariable("id") Integer id) {
		return userService.findById(id).get(); 
	}
	
	@RequestMapping(value="",method=RequestMethod.POST,consumes={"application/json"})
	public void save (@RequestBody User user) {
		userService.save(user); 	 
	}
	
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public void userSavePhoto (@RequestBody User user) {
		userService.save(user); 	 
	}
	
	
}
