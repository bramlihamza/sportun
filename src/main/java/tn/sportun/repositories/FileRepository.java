package tn.sportun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sportun.entities.File;

public interface FileRepository extends JpaRepository<File, Integer> {

}
