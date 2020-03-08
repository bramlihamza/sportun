package tn.sportun.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.sportun.entities.Information;
import tn.sportun.repositories.InformationRepository;

@Service
public class InformationService {

	@Autowired
	InformationRepository informationRepository ;

	public <S extends Information> S save(S entity) {
		return informationRepository.save(entity);
	}

	public <S extends Information> Optional<S> findOne(Example<S> example) {
		return informationRepository.findOne(example);
	}

	public Page<Information> findAll(Pageable pageable) {
		return informationRepository.findAll(pageable);
	}

	public List<Information> findAll() {
		return informationRepository.findAll();
	}

	public List<Information> findAll(Sort sort) {
		return informationRepository.findAll(sort);
	}

	public List<Information> findAllById(Iterable<Integer> ids) {
		return informationRepository.findAllById(ids);
	}

	public <S extends Information> List<S> saveAll(Iterable<S> entities) {
		return informationRepository.saveAll(entities);
	}

	public Optional<Information> findById(Integer id) {
		return informationRepository.findById(id);
	}

	public void flush() {
		informationRepository.flush();
	}

	public <S extends Information> S saveAndFlush(S entity) {
		return informationRepository.saveAndFlush(entity);
	}

	public boolean existsById(Integer id) {
		return informationRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Information> entities) {
		informationRepository.deleteInBatch(entities);
	}

	public <S extends Information> Page<S> findAll(Example<S> example, Pageable pageable) {
		return informationRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		informationRepository.deleteAllInBatch();
	}

	public Information getOne(Integer id) {
		return informationRepository.getOne(id);
	}

	public <S extends Information> long count(Example<S> example) {
		return informationRepository.count(example);
	}

	public <S extends Information> boolean exists(Example<S> example) {
		return informationRepository.exists(example);
	}

	public <S extends Information> List<S> findAll(Example<S> example) {
		return informationRepository.findAll(example);
	}

	public long count() {
		return informationRepository.count();
	}

	public void deleteById(Integer id) {
		informationRepository.deleteById(id);
	}

	public <S extends Information> List<S> findAll(Example<S> example, Sort sort) {
		return informationRepository.findAll(example, sort);
	}

	public void delete(Information entity) {
		informationRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Information> entities) {
		informationRepository.deleteAll(entities);
	}

	public void deleteAll() {
		informationRepository.deleteAll();
	} 
	
	
	
}
