package it.contrader.service.impl;

import it.contrader.service.ThingService;
import it.contrader.domain.Thing;
import it.contrader.repository.ThingRepository;
import it.contrader.service.dto.ThingDTO;
import it.contrader.service.mapper.ThingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Thing.
 */
@Service
@Transactional
public class ThingServiceImpl implements ThingService {

    private final Logger log = LoggerFactory.getLogger(ThingServiceImpl.class);

    private final ThingRepository thingRepository;

    private final ThingMapper thingMapper;

    public ThingServiceImpl(ThingRepository thingRepository, ThingMapper thingMapper) {
        this.thingRepository = thingRepository;
        this.thingMapper = thingMapper;
    }

    /**
     * Save a thing.
     *
     * @param thingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ThingDTO save(ThingDTO thingDTO) {
        log.debug("Request to save Thing : {}", thingDTO);
        Thing thing = thingMapper.toEntity(thingDTO);
        thing = thingRepository.save(thing);
        return thingMapper.toDto(thing);
    }

    /**
     * Get all the things.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ThingDTO> findAll() {
        log.debug("Request to get all Things");
        return thingRepository.findAll().stream()
            .map(thingMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one thing by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ThingDTO> findOne(Long id) {
        log.debug("Request to get Thing : {}", id);
        return thingRepository.findById(id)
            .map(thingMapper::toDto);
    }

    /**
     * Delete the thing by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Thing : {}", id);
        thingRepository.deleteById(id);
    }
}
