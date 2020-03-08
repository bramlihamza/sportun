package tn.sportun.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.sportun.entities.Demande;
import tn.sportun.repositories.DemandeRepository;

@Service
public class DemandeService {

	@Autowired
	DemandeRepository demandeRepository ;

	public <S extends Demande> S save(S entity) {
		return demandeRepository.save(entity);
	}

	public <S extends Demande> Optional<S> findOne(Example<S> example) {
		return demandeRepository.findOne(example);
	}

	public Page<Demande> findAll(Pageable pageable) {
		return demandeRepository.findAll(pageable);
	}

	public List<Demande> findAll() {
		return demandeRepository.findAll();
	}

	public List<Demande> findAll(Sort sort) {
		return demandeRepository.findAll(sort);
	}

	public List<Demande> findAllById(Iterable<Integer> ids) {
		return demandeRepository.findAllById(ids);
	}

	public <S extends Demande> List<S> saveAll(Iterable<S> entities) {
		return demandeRepository.saveAll(entities);
	}

	public Optional<Demande> findById(Integer id) {
		return demandeRepository.findById(id);
	}

	public void flush() {
		demandeRepository.flush();
	}

	public <S extends Demande> S saveAndFlush(S entity) {
		return demandeRepository.saveAndFlush(entity);
	}

	public boolean existsById(Integer id) {
		return demandeRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Demande> entities) {
		demandeRepository.deleteInBatch(entities);
	}

	public <S extends Demande> Page<S> findAll(Example<S> example, Pageable pageable) {
		return demandeRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		demandeRepository.deleteAllInBatch();
	}

	public Demande getOne(Integer id) {
		return demandeRepository.getOne(id);
	}

	public <S extends Demande> long count(Example<S> example) {
		return demandeRepository.count(example);
	}

	public <S extends Demande> boolean exists(Example<S> example) {
		return demandeRepository.exists(example);
	}

	public <S extends Demande> List<S> findAll(Example<S> example) {
		return demandeRepository.findAll(example);
	}

	public long count() {
		return demandeRepository.count();
	}

	public void deleteById(Integer id) {
		demandeRepository.deleteById(id);
	}

	public <S extends Demande> List<S> findAll(Example<S> example, Sort sort) {
		return demandeRepository.findAll(example, sort);
	}

	public void delete(Demande entity) {
		demandeRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Demande> entities) {
		demandeRepository.deleteAll(entities);
	}

	public void deleteAll() {
		demandeRepository.deleteAll();
	} 
	
	
	
}
