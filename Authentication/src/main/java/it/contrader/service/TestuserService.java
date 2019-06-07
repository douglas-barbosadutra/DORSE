package it.contrader.service;

import it.contrader.service.dto.TestuserDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Testuser.
 */
public interface TestuserService {

    /**
     * Save a testuser.
     *
     * @param testuserDTO the entity to save
     * @return the persisted entity
     */
    TestuserDTO save(TestuserDTO testuserDTO);

    /**
     * Get all the testusers.
     *
     * @return the list of entities
     */
    List<TestuserDTO> findAll();


    /**
     * Get the "id" testuser.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<TestuserDTO> findOne(Long id);

    /**
     * Delete the "id" testuser.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
