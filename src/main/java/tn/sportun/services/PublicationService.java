package tn.sportun.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.sportun.entities.Publication;
import tn.sportun.repositories.PublicationRepository;

@Service
public class PublicationService {

	@Autowired
	PublicationRepository publicationRepository ;

	public <S extends Publication> S save(S entity) {
		return publicationRepository.save(entity);
	}

	public <S extends Publication> Optional<S> findOne(Example<S> example) {
		return publicationRepository.findOne(example);
	}

	public Page<Publication> findAll(Pageable pageable) {
		return publicationRepository.findAll(pageable);
	}

	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	public List<Publication> findAll(Sort sort) {
		return publicationRepository.findAll(sort);
	}

	public List<Publication> findAllById(Iterable<Integer> ids) {
		return publicationRepository.findAllById(ids);
	}

	public <S extends Publication> List<S> saveAll(Iterable<S> entities) {
		return publicationRepository.saveAll(entities);
	}

	public Optional<Publication> findById(Integer id) {
		return publicationRepository.findById(id);
	}

	public void flush() {
		publicationRepository.flush();
	}

	public <S extends Publication> S saveAndFlush(S entity) {
		return publicationRepository.saveAndFlush(entity);
	}

	public boolean existsById(Integer id) {
		return publicationRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Publication> entities) {
		publicationRepository.deleteInBatch(entities);
	}

	public <S extends Publication> Page<S> findAll(Example<S> example, Pageable pageable) {
		return publicationRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		publicationRepository.deleteAllInBatch();
	}

	public Publication getOne(Integer id) {
		return publicationRepository.getOne(id);
	}

	public <S extends Publication> long count(Example<S> example) {
		return publicationRepository.count(example);
	}

	public <S extends Publication> boolean exists(Example<S> example) {
		return publicationRepository.exists(example);
	}

	public <S extends Publication> List<S> findAll(Example<S> example) {
		return publicationRepository.findAll(example);
	}

	public long count() {
		return publicationRepository.count();
	}

	public void deleteById(Integer id) {
		publicationRepository.deleteById(id);
	}

	public <S extends Publication> List<S> findAll(Example<S> example, Sort sort) {
		return publicationRepository.findAll(example, sort);
	}

	public void delete(Publication entity) {
		publicationRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Publication> entities) {
		publicationRepository.deleteAll(entities);
	}

	public void deleteAll() {
		publicationRepository.deleteAll();
	}
	
	
	
}
