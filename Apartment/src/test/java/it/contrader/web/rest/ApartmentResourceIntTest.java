package it.contrader.web.rest;

import it.contrader.ApartmentApp;

import it.contrader.domain.Apartment;
import it.contrader.repository.ApartmentRepository;
import it.contrader.service.ApartmentService;
import it.contrader.service.dto.ApartmentDTO;
import it.contrader.service.mapper.ApartmentMapper;
import it.contrader.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ApartmentResource REST controller.
 *
 * @see ApartmentResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApartmentApp.class)
public class ApartmentResourceIntTest {

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final Long DEFAULT_TUTOR = 1L;
    private static final Long UPDATED_TUTOR = 2L;

    private static final Long DEFAULT_CLIENT = 1L;
    private static final Long UPDATED_CLIENT = 2L;

    @Autowired
    private ApartmentRepository apartmentRepository;


    @Autowired
    private ApartmentMapper apartmentMapper;
    
    @Autowired
    private ApartmentResource apartmentResource;

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restApartmentMockMvc;

    private Apartment apartment;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.restApartmentMockMvc = MockMvcBuilders.standaloneSetup(apartmentResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Apartment createEntity(EntityManager em) {
        Apartment apartment = new Apartment()
            .address(DEFAULT_ADDRESS)
            .tutor(DEFAULT_TUTOR)
            .client(DEFAULT_CLIENT);
        return apartment;
    }

    @Before
    public void initTest() {
        apartment = createEntity(em);
    }

    @Test
    @Transactional
    public void createApartment() throws Exception {
        int databaseSizeBeforeCreate = apartmentRepository.findAll().size();

        // Create the Apartment
        ApartmentDTO apartmentDTO = apartmentMapper.toDto(apartment);
        restApartmentMockMvc.perform(post("/api/apartments")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apartmentDTO)))
            .andExpect(status().isCreated());

        // Validate the Apartment in the database
        List<Apartment> apartmentList = apartmentRepository.findAll();
        assertThat(apartmentList).hasSize(databaseSizeBeforeCreate + 1);
        Apartment testApartment = apartmentList.get(apartmentList.size() - 1);
        assertThat(testApartment.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testApartment.getTutor()).isEqualTo(DEFAULT_TUTOR);
        assertThat(testApartment.getClient()).isEqualTo(DEFAULT_CLIENT);
    }

    @Test
    @Transactional
    public void createApartmentWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = apartmentRepository.findAll().size();

        // Create the Apartment with an existing ID
        apartment.setId(1L);
        ApartmentDTO apartmentDTO = apartmentMapper.toDto(apartment);

        // An entity with an existing ID cannot be created, so this API call must fail
        restApartmentMockMvc.perform(post("/api/apartments")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apartmentDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Apartment in the database
        List<Apartment> apartmentList = apartmentRepository.findAll();
        assertThat(apartmentList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllApartments() throws Exception {
        // Initialize the database
        apartmentRepository.saveAndFlush(apartment);

        // Get all the apartmentList
        restApartmentMockMvc.perform(get("/api/apartments?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(apartment.getId().intValue())))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].tutor").value(hasItem(DEFAULT_TUTOR.intValue())))
            .andExpect(jsonPath("$.[*].client").value(hasItem(DEFAULT_CLIENT.intValue())));
    }
    

    @Test
    @Transactional
    public void getApartment() throws Exception {
        // Initialize the database
        apartmentRepository.saveAndFlush(apartment);

        // Get the apartment
        restApartmentMockMvc.perform(get("/api/apartments/{id}", apartment.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(apartment.getId().intValue()))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS.toString()))
            .andExpect(jsonPath("$.tutor").value(DEFAULT_TUTOR.intValue()))
            .andExpect(jsonPath("$.client").value(DEFAULT_CLIENT.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingApartment() throws Exception {
        // Get the apartment
        restApartmentMockMvc.perform(get("/api/apartments/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateApartment() throws Exception {
        // Initialize the database
        apartmentRepository.saveAndFlush(apartment);

        int databaseSizeBeforeUpdate = apartmentRepository.findAll().size();

        // Update the apartment
        Apartment updatedApartment = apartmentRepository.findById(apartment.getId()).get();
        // Disconnect from session so that the updates on updatedApartment are not directly saved in db
        em.detach(updatedApartment);
        updatedApartment
            .address(UPDATED_ADDRESS)
            .tutor(UPDATED_TUTOR)
            .client(UPDATED_CLIENT);
        ApartmentDTO apartmentDTO = apartmentMapper.toDto(updatedApartment);

        restApartmentMockMvc.perform(put("/api/apartments")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apartmentDTO)))
            .andExpect(status().isOk());

        // Validate the Apartment in the database
        List<Apartment> apartmentList = apartmentRepository.findAll();
        assertThat(apartmentList).hasSize(databaseSizeBeforeUpdate);
        Apartment testApartment = apartmentList.get(apartmentList.size() - 1);
        assertThat(testApartment.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testApartment.getTutor()).isEqualTo(UPDATED_TUTOR);
        assertThat(testApartment.getClient()).isEqualTo(UPDATED_CLIENT);
    }

    @Test
    @Transactional
    public void updateNonExistingApartment() throws Exception {
        int databaseSizeBeforeUpdate = apartmentRepository.findAll().size();

        // Create the Apartment
        ApartmentDTO apartmentDTO = apartmentMapper.toDto(apartment);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restApartmentMockMvc.perform(put("/api/apartments")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apartmentDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Apartment in the database
        List<Apartment> apartmentList = apartmentRepository.findAll();
        assertThat(apartmentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteApartment() throws Exception {
        // Initialize the database
        apartmentRepository.saveAndFlush(apartment);

        int databaseSizeBeforeDelete = apartmentRepository.findAll().size();

        // Get the apartment
        restApartmentMockMvc.perform(delete("/api/apartments/{id}", apartment.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Apartment> apartmentList = apartmentRepository.findAll();
        assertThat(apartmentList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Apartment.class);
        Apartment apartment1 = new Apartment();
        apartment1.setId(1L);
        Apartment apartment2 = new Apartment();
        apartment2.setId(apartment1.getId());
        assertThat(apartment1).isEqualTo(apartment2);
        apartment2.setId(2L);
        assertThat(apartment1).isNotEqualTo(apartment2);
        apartment1.setId(null);
        assertThat(apartment1).isNotEqualTo(apartment2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ApartmentDTO.class);
        ApartmentDTO apartmentDTO1 = new ApartmentDTO();
        apartmentDTO1.setId(1L);
        ApartmentDTO apartmentDTO2 = new ApartmentDTO();
        assertThat(apartmentDTO1).isNotEqualTo(apartmentDTO2);
        apartmentDTO2.setId(apartmentDTO1.getId());
        assertThat(apartmentDTO1).isEqualTo(apartmentDTO2);
        apartmentDTO2.setId(2L);
        assertThat(apartmentDTO1).isNotEqualTo(apartmentDTO2);
        apartmentDTO1.setId(null);
        assertThat(apartmentDTO1).isNotEqualTo(apartmentDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(apartmentMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(apartmentMapper.fromId(null)).isNull();
    }
}
