package it.contrader.service.impl;

import it.contrader.service.OperatorService;
import it.contrader.domain.Operator;
import it.contrader.repository.OperatorRepository;
import it.contrader.service.dto.OperatorDTO;
import it.contrader.service.mapper.OperatorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Operator.
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    private final Logger log = LoggerFactory.getLogger(OperatorServiceImpl.class);

    private final OperatorRepository operatorRepository;

    private final OperatorMapper operatorMapper;

    public OperatorServiceImpl(OperatorRepository operatorRepository, OperatorMapper operatorMapper) {
        this.operatorRepository = operatorRepository;
        this.operatorMapper = operatorMapper;
    }

    /**
     * Save a operator.
     *
     * @param operatorDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public OperatorDTO save(OperatorDTO operatorDTO) {
        log.debug("Request to save Operator : {}", operatorDTO);
        Operator operator = operatorMapper.toEntity(operatorDTO);
        operator = operatorRepository.save(operator);
        return operatorMapper.toDto(operator);
    }

    /**
     * Get all the operators.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<OperatorDTO> findAll() {
        log.debug("Request to get all Operators");
        return operatorRepository.findAll().stream()
            .map(operatorMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one operator by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OperatorDTO> findOne(Long id) {
        log.debug("Request to get Operator : {}", id);
        return operatorRepository.findById(id)
            .map(operatorMapper::toDto);
    }

    /**
     * Delete the operator by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Operator : {}", id);
        operatorRepository.deleteById(id);
    }
}
