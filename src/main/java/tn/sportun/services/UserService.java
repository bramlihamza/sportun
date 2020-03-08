package tn.sportun.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.sportun.entities.User;
import tn.sportun.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository ;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public <S extends User> S save(S entity) {
		
		String hashPW=bCryptPasswordEncoder.encode(entity.getPassword());
		entity.setPassword(hashPW);

		return userRepository.save(entity);
	}

	public <S extends User> Optional<S> findOne(Example<S> example) {
		return userRepository.findOne(example);
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	public List<User> findAllById(Iterable<Integer> ids) {
		return userRepository.findAllById(ids);
	}

	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	public void flush() {
		userRepository.flush();
	}

	public <S extends User> S saveAndFlush(S entity) {
		return userRepository.saveAndFlush(entity);
	}

	public boolean existsById(Integer id) {
		return userRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<User> entities) {
		userRepository.deleteInBatch(entities);
	}

	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	public User getOne(Integer id) {
		return userRepository.getOne(id);
	}

	public <S extends User> long count(Example<S> example) {
		return userRepository.count(example);
	}

	public <S extends User> boolean exists(Example<S> example) {
		return userRepository.exists(example);
	}

	public <S extends User> List<S> findAll(Example<S> example) {
		return userRepository.findAll(example);
	}

	public long count() {
		return userRepository.count();
	}

	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}

	public void delete(User entity) {
		userRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends User> entities) {
		userRepository.deleteAll(entities);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	} 
	
	
	
}
