package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.Converter;

@Service
public abstract class AbstractService<Entity,DTO> implements MyService<Entity,DTO> {
	
	protected CrudRepository<Entity,Long> crudRepository;
	protected Converter<Entity,DTO> converter;
	
	public AbstractService() {
	}

	@Override
	public Entity insert(DTO dto) {
		return crudRepository.save(converter.toEntity(dto));
	}

	@Override
	public List<DTO> getAll() {
		Iterable<Entity> iter = crudRepository.findAll();
		List<DTO> list = new ArrayList<>();
		for (Entity item : iter) {
	        list.add(converter.toDTO(item));
	    }
		return list;
	}

	@Override
	public DTO read(long id) {
		return converter.toDTO(crudRepository.findById(id).get());
	}

	@Override
	public Entity update(DTO dto) {
		return crudRepository.save(converter.toEntity(dto));
	}

	@Override
	public void delete(DTO dto) {
		crudRepository.delete(converter.toEntity(dto));
	}
}