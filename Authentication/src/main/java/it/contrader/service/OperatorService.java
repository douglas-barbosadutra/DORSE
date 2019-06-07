package it.contrader.service;

import it.contrader.service.dto.OperatorDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Operator.
 */
public interface OperatorService {

    /**
     * Save a operator.
     *
     * @param operatorDTO the entity to save
     * @return the persisted entity
     */
    OperatorDTO save(OperatorDTO operatorDTO);

    /**
     * Get all the operators.
     *
     * @return the list of entities
     */
    List<OperatorDTO> findAll();


    /**
     * Get the "id" operator.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<OperatorDTO> findOne(Long id);

    /**
     * Delete the "id" operator.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
