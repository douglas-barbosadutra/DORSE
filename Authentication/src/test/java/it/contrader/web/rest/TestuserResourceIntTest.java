package it.contrader.web.rest;

import it.contrader.AuthenticationApp;

import it.contrader.domain.Testuser;
import it.contrader.repository.TestuserRepository;
import it.contrader.service.TestuserService;
import it.contrader.service.dto.TestuserDTO;
import it.contrader.service.mapper.TestuserMapper;
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
 * Test class for the TestuserResource REST controller.
 *
 * @see TestuserResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthenticationApp.class)
public class TestuserResourceIntTest {

    @Autowired
    private TestuserRepository testuserRepository;


    @Autowired
    private TestuserMapper testuserMapper;
    

    @Autowired
    private TestuserService testuserService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restTestuserMockMvc;

    private Testuser testuser;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TestuserResource testuserResource = new TestuserResource(testuserService);
        this.restTestuserMockMvc = MockMvcBuilders.standaloneSetup(testuserResource)
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
    public static Testuser createEntity(EntityManager em) {
        Testuser testuser = new Testuser();
        return testuser;
    }

    @Before
    public void initTest() {
        testuser = createEntity(em);
    }

    @Test
    @Transactional
    public void createTestuser() throws Exception {
        int databaseSizeBeforeCreate = testuserRepository.findAll().size();

        // Create the Testuser
        TestuserDTO testuserDTO = testuserMapper.toDto(testuser);
        restTestuserMockMvc.perform(post("/api/testusers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(testuserDTO)))
            .andExpect(status().isCreated());

        // Validate the Testuser in the database
        List<Testuser> testuserList = testuserRepository.findAll();
        assertThat(testuserList).hasSize(databaseSizeBeforeCreate + 1);
        Testuser testTestuser = testuserList.get(testuserList.size() - 1);
    }

    @Test
    @Transactional
    public void createTestuserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = testuserRepository.findAll().size();

        // Create the Testuser with an existing ID
        testuser.setId(1L);
        TestuserDTO testuserDTO = testuserMapper.toDto(testuser);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTestuserMockMvc.perform(post("/api/testusers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(testuserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Testuser in the database
        List<Testuser> testuserList = testuserRepository.findAll();
        assertThat(testuserList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTestusers() throws Exception {
        // Initialize the database
        testuserRepository.saveAndFlush(testuser);

        // Get all the testuserList
        restTestuserMockMvc.perform(get("/api/testusers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(testuser.getId().intValue())));
    }
    

    @Test
    @Transactional
    public void getTestuser() throws Exception {
        // Initialize the database
        testuserRepository.saveAndFlush(testuser);

        // Get the testuser
        restTestuserMockMvc.perform(get("/api/testusers/{id}", testuser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(testuser.getId().intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingTestuser() throws Exception {
        // Get the testuser
        restTestuserMockMvc.perform(get("/api/testusers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTestuser() throws Exception {
        // Initialize the database
        testuserRepository.saveAndFlush(testuser);

        int databaseSizeBeforeUpdate = testuserRepository.findAll().size();

        // Update the testuser
        Testuser updatedTestuser = testuserRepository.findById(testuser.getId()).get();
        // Disconnect from session so that the updates on updatedTestuser are not directly saved in db
        em.detach(updatedTestuser);
        TestuserDTO testuserDTO = testuserMapper.toDto(updatedTestuser);

        restTestuserMockMvc.perform(put("/api/testusers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(testuserDTO)))
            .andExpect(status().isOk());

        // Validate the Testuser in the database
        List<Testuser> testuserList = testuserRepository.findAll();
        assertThat(testuserList).hasSize(databaseSizeBeforeUpdate);
        Testuser testTestuser = testuserList.get(testuserList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingTestuser() throws Exception {
        int databaseSizeBeforeUpdate = testuserRepository.findAll().size();

        // Create the Testuser
        TestuserDTO testuserDTO = testuserMapper.toDto(testuser);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restTestuserMockMvc.perform(put("/api/testusers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(testuserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Testuser in the database
        List<Testuser> testuserList = testuserRepository.findAll();
        assertThat(testuserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTestuser() throws Exception {
        // Initialize the database
        testuserRepository.saveAndFlush(testuser);

        int databaseSizeBeforeDelete = testuserRepository.findAll().size();

        // Get the testuser
        restTestuserMockMvc.perform(delete("/api/testusers/{id}", testuser.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Testuser> testuserList = testuserRepository.findAll();
        assertThat(testuserList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Testuser.class);
        Testuser testuser1 = new Testuser();
        testuser1.setId(1L);
        Testuser testuser2 = new Testuser();
        testuser2.setId(testuser1.getId());
        assertThat(testuser1).isEqualTo(testuser2);
        testuser2.setId(2L);
        assertThat(testuser1).isNotEqualTo(testuser2);
        testuser1.setId(null);
        assertThat(testuser1).isNotEqualTo(testuser2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TestuserDTO.class);
        TestuserDTO testuserDTO1 = new TestuserDTO();
        testuserDTO1.setId(1L);
        TestuserDTO testuserDTO2 = new TestuserDTO();
        assertThat(testuserDTO1).isNotEqualTo(testuserDTO2);
        testuserDTO2.setId(testuserDTO1.getId());
        assertThat(testuserDTO1).isEqualTo(testuserDTO2);
        testuserDTO2.setId(2L);
        assertThat(testuserDTO1).isNotEqualTo(testuserDTO2);
        testuserDTO1.setId(null);
        assertThat(testuserDTO1).isNotEqualTo(testuserDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(testuserMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(testuserMapper.fromId(null)).isNull();
    }
}
