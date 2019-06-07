package it.contrader.service.impl;

import it.contrader.service.SuperuserService;
import it.contrader.domain.Superuser;
import it.contrader.repository.SuperuserRepository;
import it.contrader.service.dto.SuperuserDTO;
import it.contrader.service.mapper.SuperuserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Superuser.
 */
@Service
@Transactional
public class SuperuserServiceImpl implements SuperuserService {

    private final Logger log = LoggerFactory.getLogger(SuperuserServiceImpl.class);

    private final SuperuserRepository superuserRepository;

    private final SuperuserMapper superuserMapper;

    public SuperuserServiceImpl(SuperuserRepository superuserRepository, SuperuserMapper superuserMapper) {
        this.superuserRepository = superuserRepository;
        this.superuserMapper = superuserMapper;
    }

    /**
     * Save a superuser.
     *
     * @param superuserDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SuperuserDTO save(SuperuserDTO superuserDTO) {
        log.debug("Request to save Superuser : {}", superuserDTO);
        Superuser superuser = superuserMapper.toEntity(superuserDTO);
        superuser = superuserRepository.save(superuser);
        return superuserMapper.toDto(superuser);
    }

    /**
     * Get all the superusers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<SuperuserDTO> findAll() {
        log.debug("Request to get all Superusers");
        return superuserRepository.findAll().stream()
            .map(superuserMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one superuser by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SuperuserDTO> findOne(Long id) {
        log.debug("Request to get Superuser : {}", id);
        return superuserRepository.findById(id)
            .map(superuserMapper::toDto);
    }

    /**
     * Delete the superuser by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Superuser : {}", id);
        superuserRepository.deleteById(id);
    }
}
