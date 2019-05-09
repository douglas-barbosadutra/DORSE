package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.Converter;

@Service
public abstract class AbstractService<Entity,DTO> implements ServiceDTO<Entity,DTO> {
	
	@Autowired
	protected CrudRepository<Entity,Long> crudRepository;
	@Autowired
	protected Converter<Entity,DTO> converter;
	
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
	public void delete(long id) {
		crudRepository.deleteById(id);
	}
}