package tn.sportun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sportun.entities.Information;

public interface InformationRepository extends JpaRepository<Information, Integer> {

}
