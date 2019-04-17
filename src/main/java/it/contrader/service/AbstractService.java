package it.contrader.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.Converter;

//T = entity, V = DTO
@Service
public class AbstractService<T,V> implements ServiceDTO<T,V> {
	
	protected CrudRepository<T,Long> crudRepository;
	protected Converter<T,V> converter;
	
	public AbstractService() {
	}

	@Override
	public T insert(V v) {
		return crudRepository.save(converter.toEntity(v));
	}

	@Override
	public List<V> getAll() {
		return (List<V>) crudRepository.findAll();
	}

	@Override
	public V read(long id) {
		return converter.toDTO((T)crudRepository.findById(id));
	}

	@Override
	public T update(V v) {
		return crudRepository.save(converter.toEntity(v));
	}

	@Override
	public void delete(V v) {
		crudRepository.delete(converter.toEntity(v));
	}
}