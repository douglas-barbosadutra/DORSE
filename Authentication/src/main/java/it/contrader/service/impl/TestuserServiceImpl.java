package it.contrader.service.impl;

import it.contrader.service.TestuserService;
import it.contrader.domain.Testuser;
import it.contrader.repository.TestuserRepository;
import it.contrader.service.dto.TestuserDTO;
import it.contrader.service.mapper.TestuserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Testuser.
 */
@Service
@Transactional
public class TestuserServiceImpl implements TestuserService {

    private final Logger log = LoggerFactory.getLogger(TestuserServiceImpl.class);

    private final TestuserRepository testuserRepository;

    private final TestuserMapper testuserMapper;

    public TestuserServiceImpl(TestuserRepository testuserRepository, TestuserMapper testuserMapper) {
        this.testuserRepository = testuserRepository;
        this.testuserMapper = testuserMapper;
    }

    /**
     * Save a testuser.
     *
     * @param testuserDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TestuserDTO save(TestuserDTO testuserDTO) {
        log.debug("Request to save Testuser : {}", testuserDTO);
        Testuser testuser = testuserMapper.toEntity(testuserDTO);
        testuser = testuserRepository.save(testuser);
        return testuserMapper.toDto(testuser);
    }

    /**
     * Get all the testusers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TestuserDTO> findAll() {
        log.debug("Request to get all Testusers");
        return testuserRepository.findAll().stream()
            .map(testuserMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one testuser by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TestuserDTO> findOne(Long id) {
        log.debug("Request to get Testuser : {}", id);
        return testuserRepository.findById(id)
            .map(testuserMapper::toDto);
    }

    /**
     * Delete the testuser by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Testuser : {}", id);
        testuserRepository.deleteById(id);
    }
}
