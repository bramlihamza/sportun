package tn.sportun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sportun.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	
}
