package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.GenericMapper;
import it.contrader.dao.MyRepository;

public abstract class AbstractService<Entity,DTO> implements ServiceDTO<Entity,DTO> {
	
	@Autowired
	protected MyRepository<Entity,Long> myRepository;
	@Autowired
	protected GenericMapper<Entity,DTO> mapper;
	
	@Override
	public Entity insert(DTO dto) {
		return myRepository.save(mapper.toEntity(dto));
	}

	@Override
	public Iterable<DTO> getAll() {
		return mapper.toDTO(myRepository.findAll());
	}
	
	//GETS all entities depending on id of a parameter, see (Entity)Repository
	@Override
	public Iterable<DTO> getAllBy(long id) {
		return mapper.toDTO(myRepository.findAllBy(id));
	}

	@Override
	public DTO read(long id) {
		return mapper.toDTO(myRepository.findById(id).get());
	}

	@Override
	public Entity update(DTO dto) {
		return myRepository.save(mapper.toEntity(dto));
	}

	@Override
	public void delete(long id) {
		myRepository.deleteById(id);
	}
}