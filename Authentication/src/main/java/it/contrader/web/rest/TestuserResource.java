package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.TestuserService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.service.dto.TestuserDTO;
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
 * REST controller for managing Testuser.
 */
@RestController
@RequestMapping("/api")
public class TestuserResource {

    private final Logger log = LoggerFactory.getLogger(TestuserResource.class);

    private static final String ENTITY_NAME = "testuser";

    private final TestuserService testuserService;

    public TestuserResource(TestuserService testuserService) {
        this.testuserService = testuserService;
    }

    /**
     * POST  /testusers : Create a new testuser.
     *
     * @param testuserDTO the testuserDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new testuserDTO, or with status 400 (Bad Request) if the testuser has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/testusers")
    @Timed
    public ResponseEntity<TestuserDTO> createTestuser(@RequestBody TestuserDTO testuserDTO) throws URISyntaxException {
        log.debug("REST request to save Testuser : {}", testuserDTO);
        if (testuserDTO.getId() != null) {
            throw new BadRequestAlertException("A new testuser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TestuserDTO result = testuserService.save(testuserDTO);
        return ResponseEntity.created(new URI("/api/testusers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /testusers : Updates an existing testuser.
     *
     * @param testuserDTO the testuserDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated testuserDTO,
     * or with status 400 (Bad Request) if the testuserDTO is not valid,
     * or with status 500 (Internal Server Error) if the testuserDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/testusers")
    @Timed
    public ResponseEntity<TestuserDTO> updateTestuser(@RequestBody TestuserDTO testuserDTO) throws URISyntaxException {
        log.debug("REST request to update Testuser : {}", testuserDTO);
        if (testuserDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TestuserDTO result = testuserService.save(testuserDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, testuserDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /testusers : get all the testusers.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of testusers in body
     */
    @GetMapping("/testusers")
    @Timed
    public List<TestuserDTO> getAllTestusers() {
        log.debug("REST request to get all Testusers");
        return testuserService.findAll();
    }

    /**
     * GET  /testusers/:id : get the "id" testuser.
     *
     * @param id the id of the testuserDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the testuserDTO, or with status 404 (Not Found)
     */
    @GetMapping("/testusers/{id}")
    @Timed
    public ResponseEntity<TestuserDTO> getTestuser(@PathVariable Long id) {
        log.debug("REST request to get Testuser : {}", id);
        Optional<TestuserDTO> testuserDTO = testuserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(testuserDTO);
    }

    /**
     * DELETE  /testusers/:id : delete the "id" testuser.
     *
     * @param id the id of the testuserDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/testusers/{id}")
    @Timed
    public ResponseEntity<Void> deleteTestuser(@PathVariable Long id) {
        log.debug("REST request to delete Testuser : {}", id);
        testuserService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
