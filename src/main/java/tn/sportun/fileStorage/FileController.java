package tn.sportun.fileStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.sportun.entities.File;
import tn.sportun.entities.Publication;
import tn.sportun.entities.User;
import tn.sportun.services.FileService;
import tn.sportun.services.PublicationService;
import tn.sportun.services.UserService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    UserService userService ; 
    @Autowired
    PublicationService publicationService ; 
    @Autowired
    FileService fileService ;
    
    @PostMapping("/uploadphoto/publication/{id}")
    public void uploadFileUser(@RequestParam("file") MultipartFile file ,
    		@PathVariable("id") Integer id) {
    	
    	Publication publication = publicationService.findById(id).get() ;
    	
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        
       File fileuploaded = new File() ;
       
       fileuploaded.setExtension(fileName);
       fileuploaded.setFileName(fileDownloadUri);
       fileuploaded.setPublication(publication);
       
       
       
       List <File> lfiles =  publication.getFiles() ;
       
       lfiles.add(fileuploaded) ;
       
       lfiles.stream().forEach(f->{
    	   System.out.println(f.getFileName());
       });
       
       fileService.save(fileuploaded) ;
       
       publication.setFiles(lfiles);
       
       publicationService.save(publication);
       
       fileuploaded.setPublication(publication);
       publication.getFiles().stream().forEach(fp -> { 
    	   System.out.println("fp" + fp);
       });
       
       
       
        new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
        
       publicationService.save(publication);
    }
    
    
    @PostMapping("/uploadphoto/user/{id}")
    public void uploadFilePublication(@RequestParam("file") MultipartFile file ,
    		@PathVariable("id") Integer id) {
    	User user = userService.findById(id).get() ;
    	
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        
       File fileuploaded = new File() ;
       
       fileuploaded.setExtension(fileName);
       fileuploaded.setFileName(fileDownloadUri);
       
       fileService.save(fileuploaded) ;
       
       user.setPhoto(fileuploaded);
   
        new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
        
        userService.save(user);
    }
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
    @GetMapping("/downloadFile/exist/{fileName:.+}")
    public boolean testfile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        Boolean test =true ;
        String response =  new String() ;
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
            test=false ;
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
            test=false ;
        }

        if (test==true) {
        	 response = "{"+'"'+"testfield"+'"'+":"+'"'+"true"+'"'+"}" ;
        }else {
        	 response = "{"+'"'+"testfield"+'"'+":"+'"'+"false"+'"'+"}" ;
        }
        
        return test;
    }
    
    
}
