package tn.sportun.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.sportun.entities.Reponse;
import tn.sportun.repositories.ReponseRepository;

@Service
public class ReponseService {

	@Autowired
	ReponseRepository reponseRepository ;

	public <S extends Reponse> S save(S entity) {
		return reponseRepository.save(entity);
	}

	public <S extends Reponse> Optional<S> findOne(Example<S> example) {
		return reponseRepository.findOne(example);
	}

	public Page<Reponse> findAll(Pageable pageable) {
		return reponseRepository.findAll(pageable);
	}

	public List<Reponse> findAll() {
		return reponseRepository.findAll();
	}

	public List<Reponse> findAll(Sort sort) {
		return reponseRepository.findAll(sort);
	}

	public List<Reponse> findAllById(Iterable<Integer> ids) {
		return reponseRepository.findAllById(ids);
	}

	public <S extends Reponse> List<S> saveAll(Iterable<S> entities) {
		return reponseRepository.saveAll(entities);
	}

	public Optional<Reponse> findById(Integer id) {
		return reponseRepository.findById(id);
	}

	public void flush() {
		reponseRepository.flush();
	}

	public <S extends Reponse> S saveAndFlush(S entity) {
		return reponseRepository.saveAndFlush(entity);
	}

	public boolean existsById(Integer id) {
		return reponseRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Reponse> entities) {
		reponseRepository.deleteInBatch(entities);
	}

	public <S extends Reponse> Page<S> findAll(Example<S> example, Pageable pageable) {
		return reponseRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		reponseRepository.deleteAllInBatch();
	}

	public Reponse getOne(Integer id) {
		return reponseRepository.getOne(id);
	}

	public <S extends Reponse> long count(Example<S> example) {
		return reponseRepository.count(example);
	}

	public <S extends Reponse> boolean exists(Example<S> example) {
		return reponseRepository.exists(example);
	}

	public <S extends Reponse> List<S> findAll(Example<S> example) {
		return reponseRepository.findAll(example);
	}

	public long count() {
		return reponseRepository.count();
	}

	public void deleteById(Integer id) {
		reponseRepository.deleteById(id);
	}

	public <S extends Reponse> List<S> findAll(Example<S> example, Sort sort) {
		return reponseRepository.findAll(example, sort);
	}

	public void delete(Reponse entity) {
		reponseRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Reponse> entities) {
		reponseRepository.deleteAll(entities);
	}

	public void deleteAll() {
		reponseRepository.deleteAll();
	} 
	
	
	
	
}
