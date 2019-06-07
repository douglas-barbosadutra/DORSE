package it.contrader.service;

import it.contrader.service.dto.ApartmentDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Apartment.
 */
public interface ApartmentService {

    /**
     * Save a apartment.
     *
     * @param apartmentDTO the entity to save
     * @return the persisted entity
     */
    ApartmentDTO save(ApartmentDTO apartmentDTO);

    /**
     * Get all the apartments.
     *
     * @return the list of entities
     */
    List<ApartmentDTO> findAll();


    /**
     * Get the "id" apartment.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ApartmentDTO> findOne(Long id);

    /**
     * Delete the "id" apartment.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
