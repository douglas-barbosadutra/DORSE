package it.contrader.service;

import it.contrader.service.mapper.EntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.contrader.repository.MyRepository;
import it.contrader.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
public abstract class AbstractService<Entity,DTO> implements Service<DTO> {

	/**
	 * Generic Service methods
	 */
	
//		TODO:
//	    private final Logger log = LoggerFactory.getLogger(ApartmentServiceImpl.class);
		
		@Autowired
	    private MyRepository<Entity, Long> repository;
		@Autowired
	    private EntityMapper<DTO, Entity> mapper;


	    /**
	     * Save an entity.
	     *
	     * @param DTO the entity to save
	     * @return the persisted entity
	     */
	 
	    public DTO save(DTO dto) {
//	    	TODO:
//	        log.debug("Request to save Apartment : {}", apartmentDTO);
	        Entity entity = mapper.toEntity(dto);
	        entity = repository.save(entity);
	        return mapper.toDto(entity);
	    }

	    /**
	     * Get all entities.
	     *
	     * @return the list of entities
	     */
	    
	    @Transactional(readOnly = true)
	    public List<DTO> findAll() {
//	    	TODO:
//	        log.debug("Request to get all Apartments");
	        return repository.findAll().stream()
	            .map(mapper::toDto)
	            .collect(Collectors.toCollection(LinkedList::new));
	    }
	    
	    
	    public List<DTO> findAllBy(Long id) {
	    	return repository.findAllBy(id).stream()
		            .map(mapper::toDto)
		            .collect(Collectors.toCollection(LinkedList::new));
	    }


	    /**
	     * Get one entity by id.
	     *
	     * @param id the id of the entity
	     * @return the entity
	     */
	   
	    @Transactional(readOnly = true)
	    public Optional<DTO> findOne(Long id) {
//	    	TODO:
//	        log.debug("Request to get Apartment : {}", id);
	        return repository.findById(id)
	            .map(mapper::toDto);
	    }

	    /**
	     * Delete entity by id.
	     *
	     * @param id the id of the entity
	     */
	    
	    public void delete(Long id) {
//	    	TODO:
//	        log.debug("Request to delete Apartment : {}", id);
	        repository.deleteById(id);
	    }
	

}
