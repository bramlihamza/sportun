package tn.sportun;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import tn.sportun.entities.Demande;
import tn.sportun.entities.File;
import tn.sportun.entities.Information;
import tn.sportun.entities.Proposition;
import tn.sportun.entities.Publication;
import tn.sportun.entities.User;
import tn.sportun.repositories.DemandeRepository;
import tn.sportun.repositories.FileRepository;
import tn.sportun.repositories.InformationRepository;
import tn.sportun.repositories.PropositionRepository;
import tn.sportun.repositories.PublicationRepository;
import tn.sportun.repositories.UserRepository;

@SpringBootApplication
@EnableConfigurationProperties({
    tn.sportun.fileStorage.FileStorageProperties.class
})
public class SporTunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SporTunApplication.class, args);
	}

	@Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:4200","http://localhost:8100","files://","*");
	        }
	    };
	}
	
//	@Bean
//	CommandLineRunner start (UserRepository ur ,PublicationRepository pr , 
//			DemandeRepository dr , InformationRepository ir 
//			, PropositionRepository pror ,FileRepository fr ) {
//		return args->{
//			for (int i = 0 ; i<3 ; i++) {
//				User user = new User() ;
//				user.setNom("first Terst User");
//				ur.save(user);
//				
//				Demande publication  = new Demande() ; 
//				Information  info = new Information () ; 
//				Proposition proposition = new Proposition() ; 
//				
//				//**
//				
//				info.setDescription("first information");
//				info.setUser(user);
//				ir.save(info) ;
//				
//				proposition.setDescription("first proposition");
//				proposition.setUser(user);
//				pror.save(proposition) ;
//				
//				
//				
//				
////				publication.setDescription("first test publciation");
////				publication.setUser(user);
////				
////				pr.save( publication) ;
//				 
//				Collection<Publication> l =pr.findAll();
//			}
//			
//			
//			
//			
//		};
//	}
	
	
	
	
	
}
