package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.TutorService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.service.dto.TutorDTO;
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
 * REST controller for managing Tutor.
 */
@RestController
@RequestMapping("/api")
public class TutorResource {

    private final Logger log = LoggerFactory.getLogger(TutorResource.class);

    private static final String ENTITY_NAME = "tutor";

    private final TutorService tutorService;

    public TutorResource(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    /**
     * POST  /tutors : Create a new tutor.
     *
     * @param tutorDTO the tutorDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tutorDTO, or with status 400 (Bad Request) if the tutor has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tutors")
    @Timed
    public ResponseEntity<TutorDTO> createTutor(@RequestBody TutorDTO tutorDTO) throws URISyntaxException {
        log.debug("REST request to save Tutor : {}", tutorDTO);
        if (tutorDTO.getId() != null) {
            throw new BadRequestAlertException("A new tutor cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TutorDTO result = tutorService.save(tutorDTO);
        return ResponseEntity.created(new URI("/api/tutors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tutors : Updates an existing tutor.
     *
     * @param tutorDTO the tutorDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tutorDTO,
     * or with status 400 (Bad Request) if the tutorDTO is not valid,
     * or with status 500 (Internal Server Error) if the tutorDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tutors")
    @Timed
    public ResponseEntity<TutorDTO> updateTutor(@RequestBody TutorDTO tutorDTO) throws URISyntaxException {
        log.debug("REST request to update Tutor : {}", tutorDTO);
        if (tutorDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TutorDTO result = tutorService.save(tutorDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tutorDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tutors : get all the tutors.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tutors in body
     */
    @GetMapping("/tutors")
    @Timed
    public List<TutorDTO> getAllTutors() {
        log.debug("REST request to get all Tutors");
        return tutorService.findAll();
    }

    /**
     * GET  /tutors/:id : get the "id" tutor.
     *
     * @param id the id of the tutorDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tutorDTO, or with status 404 (Not Found)
     */
    @GetMapping("/tutors/{id}")
    @Timed
    public ResponseEntity<TutorDTO> getTutor(@PathVariable Long id) {
        log.debug("REST request to get Tutor : {}", id);
        Optional<TutorDTO> tutorDTO = tutorService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tutorDTO);
    }

    /**
     * DELETE  /tutors/:id : delete the "id" tutor.
     *
     * @param id the id of the tutorDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tutors/{id}")
    @Timed
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        log.debug("REST request to delete Tutor : {}", id);
        tutorService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
