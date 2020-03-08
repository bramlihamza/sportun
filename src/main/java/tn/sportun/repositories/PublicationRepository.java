package tn.sportun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sportun.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

	
}
