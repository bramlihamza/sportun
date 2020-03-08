package tn.sportun.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.sportun.entities.Proposition;
import tn.sportun.repositories.PropositionRepository;

@Service
public class PropositionService {

	@Autowired
	PropositionRepository propositionRepository ;

	public <S extends Proposition> S save(S entity) {
		return propositionRepository.save(entity);
	}

	public <S extends Proposition> Optional<S> findOne(Example<S> example) {
		return propositionRepository.findOne(example);
	}

	public Page<Proposition> findAll(Pageable pageable) {
		return propositionRepository.findAll(pageable);
	}

	public List<Proposition> findAll() {
		return propositionRepository.findAll();
	}

	public List<Proposition> findAll(Sort sort) {
		return propositionRepository.findAll(sort);
	}

	public List<Proposition> findAllById(Iterable<Integer> ids) {
		return propositionRepository.findAllById(ids);
	}

	public <S extends Proposition> List<S> saveAll(Iterable<S> entities) {
		return propositionRepository.saveAll(entities);
	}

	public Optional<Proposition> findById(Integer id) {
		return propositionRepository.findById(id);
	}

	public void flush() {
		propositionRepository.flush();
	}

	public <S extends Proposition> S saveAndFlush(S entity) {
		return propositionRepository.saveAndFlush(entity);
	}

	public boolean existsById(Integer id) {
		return propositionRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Proposition> entities) {
		propositionRepository.deleteInBatch(entities);
	}

	public <S extends Proposition> Page<S> findAll(Example<S> example, Pageable pageable) {
		return propositionRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		propositionRepository.deleteAllInBatch();
	}

	public Proposition getOne(Integer id) {
		return propositionRepository.getOne(id);
	}

	public <S extends Proposition> long count(Example<S> example) {
		return propositionRepository.count(example);
	}

	public <S extends Proposition> boolean exists(Example<S> example) {
		return propositionRepository.exists(example);
	}

	public <S extends Proposition> List<S> findAll(Example<S> example) {
		return propositionRepository.findAll(example);
	}

	public long count() {
		return propositionRepository.count();
	}

	public void deleteById(Integer id) {
		propositionRepository.deleteById(id);
	}

	public <S extends Proposition> List<S> findAll(Example<S> example, Sort sort) {
		return propositionRepository.findAll(example, sort);
	}

	public void delete(Proposition entity) {
		propositionRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Proposition> entities) {
		propositionRepository.deleteAll(entities);
	}

	public void deleteAll() {
		propositionRepository.deleteAll();
	} 
	
	
	
}
