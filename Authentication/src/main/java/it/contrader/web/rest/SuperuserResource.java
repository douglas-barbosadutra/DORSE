package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.SuperuserService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.service.dto.SuperuserDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Superuser.
 */
@RestController
@RequestMapping("/api")
public class SuperuserResource {

    private final Logger log = LoggerFactory.getLogger(SuperuserResource.class);

    private static final String ENTITY_NAME = "superuser";

    private final SuperuserService superuserService;

    public SuperuserResource(SuperuserService superuserService) {
        this.superuserService = superuserService;
    }

    /**
     * POST  /superusers : Create a new superuser.
     *
     * @param superuserDTO the superuserDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new superuserDTO, or with status 400 (Bad Request) if the superuser has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/superusers")
    @Timed
    public ResponseEntity<SuperuserDTO> createSuperuser(@RequestBody SuperuserDTO superuserDTO) throws URISyntaxException {
        log.debug("REST request to save Superuser : {}", superuserDTO);
        if (superuserDTO.getId() != null) {
            throw new BadRequestAlertException("A new superuser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SuperuserDTO result = superuserService.save(superuserDTO);
        return ResponseEntity.created(new URI("/api/superusers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /superusers : Updates an existing superuser.
     *
     * @param superuserDTO the superuserDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated superuserDTO,
     * or with status 400 (Bad Request) if the superuserDTO is not valid,
     * or with status 500 (Internal Server Error) if the superuserDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/superusers")
    @Timed
    public ResponseEntity<SuperuserDTO> updateSuperuser(@RequestBody SuperuserDTO superuserDTO) throws URISyntaxException {
        log.debug("REST request to update Superuser : {}", superuserDTO);
        if (superuserDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SuperuserDTO result = superuserService.save(superuserDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, superuserDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /superusers : get all the superusers.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of superusers in body
     */
    @GetMapping("/superusers")
    @Timed
    public List<SuperuserDTO> getAllSuperusers() {
        log.debug("REST request to get all Superusers");
        return superuserService.findAll();
    }

    /**
     * GET  /superusers/:id : get the "id" superuser.
     *
     * @param id the id of the superuserDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the superuserDTO, or with status 404 (Not Found)
     */
    @GetMapping("/superusers/{id}")
    @Timed
    public ResponseEntity<SuperuserDTO> getSuperuser(@PathVariable Long id) {
        log.debug("REST request to get Superuser : {}", id);
        Optional<SuperuserDTO> superuserDTO = superuserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(superuserDTO);
    }

    /**
     * DELETE  /superusers/:id : delete the "id" superuser.
     *
     * @param id the id of the superuserDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/superusers/{id}")
    @Timed
    public ResponseEntity<Void> deleteSuperuser(@PathVariable Long id) {
        log.debug("REST request to delete Superuser : {}", id);
        superuserService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
