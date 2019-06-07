package it.contrader.service.impl;

import it.contrader.service.ApartmentService;
import it.contrader.domain.Apartment;
import it.contrader.repository.ApartmentRepository;
import it.contrader.service.dto.ApartmentDTO;
import it.contrader.service.mapper.ApartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Apartment.
 */
@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {

    private final Logger log = LoggerFactory.getLogger(ApartmentServiceImpl.class);

    private final ApartmentRepository apartmentRepository;

    private final ApartmentMapper apartmentMapper;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ApartmentMapper apartmentMapper) {
        this.apartmentRepository = apartmentRepository;
        this.apartmentMapper = apartmentMapper;
    }

    /**
     * Save a apartment.
     *
     * @param apartmentDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ApartmentDTO save(ApartmentDTO apartmentDTO) {
        log.debug("Request to save Apartment : {}", apartmentDTO);
        Apartment apartment = apartmentMapper.toEntity(apartmentDTO);
        apartment = apartmentRepository.save(apartment);
        return apartmentMapper.toDto(apartment);
    }

    /**
     * Get all the apartments.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ApartmentDTO> findAll() {
        log.debug("Request to get all Apartments");
        return apartmentRepository.findAll().stream()
            .map(apartmentMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one apartment by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ApartmentDTO> findOne(Long id) {
        log.debug("Request to get Apartment : {}", id);
        return apartmentRepository.findById(id)
            .map(apartmentMapper::toDto);
    }

    /**
     * Delete the apartment by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Apartment : {}", id);
        apartmentRepository.deleteById(id);
    }
}
