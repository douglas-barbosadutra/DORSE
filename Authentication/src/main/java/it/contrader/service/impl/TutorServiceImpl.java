package it.contrader.service.impl;

import it.contrader.service.TutorService;
import it.contrader.domain.Tutor;
import it.contrader.repository.TutorRepository;
import it.contrader.service.dto.TutorDTO;
import it.contrader.service.mapper.TutorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Tutor.
 */
@Service
@Transactional
public class TutorServiceImpl implements TutorService {

    private final Logger log = LoggerFactory.getLogger(TutorServiceImpl.class);

    private final TutorRepository tutorRepository;

    private final TutorMapper tutorMapper;

    public TutorServiceImpl(TutorRepository tutorRepository, TutorMapper tutorMapper) {
        this.tutorRepository = tutorRepository;
        this.tutorMapper = tutorMapper;
    }

    /**
     * Save a tutor.
     *
     * @param tutorDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TutorDTO save(TutorDTO tutorDTO) {
        log.debug("Request to save Tutor : {}", tutorDTO);
        Tutor tutor = tutorMapper.toEntity(tutorDTO);
        tutor = tutorRepository.save(tutor);
        return tutorMapper.toDto(tutor);
    }

    /**
     * Get all the tutors.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TutorDTO> findAll() {
        log.debug("Request to get all Tutors");
        return tutorRepository.findAll().stream()
            .map(tutorMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one tutor by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TutorDTO> findOne(Long id) {
        log.debug("Request to get Tutor : {}", id);
        return tutorRepository.findById(id)
            .map(tutorMapper::toDto);
    }

    /**
     * Delete the tutor by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Tutor : {}", id);
        tutorRepository.deleteById(id);
    }
}
