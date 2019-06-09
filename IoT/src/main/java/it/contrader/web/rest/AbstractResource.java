package it.contrader.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import it.contrader.service.Service;
import com.codahale.metrics.annotation.Timed;

import io.github.jhipster.web.util.ResponseUtil;
import it.contrader.web.rest.util.HeaderUtil;




public abstract class AbstractResource<DTO> {
	
//	  TODO
//    private final Logger log = LoggerFactory.getLogger(ApartmentResource.class);

    protected static final String ENTITY_NAME="entity";
    
    @Autowired
    private  Service<DTO> service;
    



    /**
     * POST  /apartments : Create a new apartment
     *
     * @param apartmentDTO the apartmentDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new apartmentDTO, or with status 400 (Bad Request) if the apartment has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/create")
    @Timed
    public ResponseEntity<DTO> create(@RequestBody DTO dto) throws URISyntaxException {
//        log.debug("REST request to save Apartment : {}", apartmentDTO);
       
        DTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/" + ENTITY_NAME + "s/" + "0"))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, "ok giro"))
            .body(result);
    }

    /**
     * PUT  /apartments : Updates an existing apartment.
     *
     * @param apartmentDTO the apartmentDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated apartmentDTO,
     * or with status 400 (Bad Request) if the apartmentDTO is not valid,
     * or with status 500 (Internal Server Error) if the apartmentDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/update" )
    @Timed
    public ResponseEntity<DTO> update(@RequestBody DTO dto) throws URISyntaxException {
//        log.debug("REST request to update Apartment : {}", apartmentDTO);
        
        DTO result = service.save(dto);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, "ok giro"))
            .body(result);
    }

    /**
     * GET  /apartments : get all the apartments.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of apartments in body
     */
    @GetMapping("/getAll")
    @Timed
    public List<DTO> getAll() {
//        log.debug("REST request to get all Apartments");
        return service.findAll();
    }
    
    @GetMapping("/getAllBy/{id}")
    @Timed
    public List<DTO> getAllBy(@PathVariable Long id) {
//        log.debug("REST request to get all Apartments");
        return service.findAllBy(id);
    }

    /**
     * GET  /apartments/:id : get the "id" apartment.
     *
     * @param id the id of the apartmentDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the apartmentDTO, or with status 404 (Not Found)
     */
    @GetMapping("/read/{id}")
    @Timed
    public ResponseEntity<DTO> get(@PathVariable Long id) {
//        log.debug("REST request to get Apartment : {}", id);
        Optional<DTO> dto = service.findOne(id);
        return ResponseUtil.wrapOrNotFound(dto);
    }

    /**
     * DELETE  /apartments/:id : delete the "id" apartment.
     *
     * @param id the id of the apartmentDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    @Timed
    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        log.debug("REST request to delete Apartment : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
