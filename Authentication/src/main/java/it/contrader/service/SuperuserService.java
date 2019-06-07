package it.contrader.service;

import it.contrader.service.dto.SuperuserDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Superuser.
 */
public interface SuperuserService {

    /**
     * Save a superuser.
     *
     * @param superuserDTO the entity to save
     * @return the persisted entity
     */
    SuperuserDTO save(SuperuserDTO superuserDTO);

    /**
     * Get all the superusers.
     *
     * @return the list of entities
     */
    List<SuperuserDTO> findAll();


    /**
     * Get the "id" superuser.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<SuperuserDTO> findOne(Long id);

    /**
     * Delete the "id" superuser.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
