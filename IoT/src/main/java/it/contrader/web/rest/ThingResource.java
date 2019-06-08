package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.ThingService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.service.dto.ThingDTO;
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
 * REST controller for managing Thing.
 */
@RestController
@RequestMapping("/api")
public class ThingResource {

    private final Logger log = LoggerFactory.getLogger(ThingResource.class);

    private static final String ENTITY_NAME = "thing";

    private final ThingService thingService;

    public ThingResource(ThingService thingService) {
        this.thingService = thingService;
    }

    /**
     * POST  /things : Create a new thing.
     *
     * @param thingDTO the thingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new thingDTO, or with status 400 (Bad Request) if the thing has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/things")
    @Timed
    public ResponseEntity<ThingDTO> createThing(@RequestBody ThingDTO thingDTO) throws URISyntaxException {
        log.debug("REST request to save Thing : {}", thingDTO);
        if (thingDTO.getId() != null) {
            throw new BadRequestAlertException("A new thing cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ThingDTO result = thingService.save(thingDTO);
        return ResponseEntity.created(new URI("/api/things/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /things : Updates an existing thing.
     *
     * @param thingDTO the thingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated thingDTO,
     * or with status 400 (Bad Request) if the thingDTO is not valid,
     * or with status 500 (Internal Server Error) if the thingDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/things")
    @Timed
    public ResponseEntity<ThingDTO> updateThing(@RequestBody ThingDTO thingDTO) throws URISyntaxException {
        log.debug("REST request to update Thing : {}", thingDTO);
        if (thingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ThingDTO result = thingService.save(thingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, thingDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /things : get all the things.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of things in body
     */
    @GetMapping("/things")
    @Timed
    public List<ThingDTO> getAllThings() {
        log.debug("REST request to get all Things");
        return thingService.findAll();
    }

    /**
     * GET  /things/:id : get the "id" thing.
     *
     * @param id the id of the thingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the thingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/things/{id}")
    @Timed
    public ResponseEntity<ThingDTO> getThing(@PathVariable Long id) {
        log.debug("REST request to get Thing : {}", id);
        Optional<ThingDTO> thingDTO = thingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(thingDTO);
    }

    /**
     * DELETE  /things/:id : delete the "id" thing.
     *
     * @param id the id of the thingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/things/{id}")
    @Timed
    public ResponseEntity<Void> deleteThing(@PathVariable Long id) {
        log.debug("REST request to delete Thing : {}", id);
        thingService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
