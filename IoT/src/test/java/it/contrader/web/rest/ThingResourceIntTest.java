package it.contrader.web.rest;

import it.contrader.IoTApp;

import it.contrader.domain.Thing;
import it.contrader.repository.ThingRepository;
import it.contrader.service.ThingService;
import it.contrader.service.dto.ThingDTO;
import it.contrader.service.mapper.ThingMapper;
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
 * Test class for the ThingResource REST controller.
 *
 * @see ThingResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IoTApp.class)
public class ThingResourceIntTest {

    private static final Long DEFAULT_ROOM = 1L;
    private static final Long UPDATED_ROOM = 2L;

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    @Autowired
    private ThingRepository thingRepository;


    @Autowired
    private ThingMapper thingMapper;
    

    @Autowired
    private ThingService thingService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restThingMockMvc;

    private Thing thing;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ThingResource thingResource = new ThingResource(thingService);
        this.restThingMockMvc = MockMvcBuilders.standaloneSetup(thingResource)
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
    public static Thing createEntity(EntityManager em) {
        Thing thing = new Thing()
            .room(DEFAULT_ROOM)
            .description(DEFAULT_DESCRIPTION);
        return thing;
    }

    @Before
    public void initTest() {
        thing = createEntity(em);
    }

    @Test
    @Transactional
    public void createThing() throws Exception {
        int databaseSizeBeforeCreate = thingRepository.findAll().size();

        // Create the Thing
        ThingDTO thingDTO = thingMapper.toDto(thing);
        restThingMockMvc.perform(post("/api/things")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(thingDTO)))
            .andExpect(status().isCreated());

        // Validate the Thing in the database
        List<Thing> thingList = thingRepository.findAll();
        assertThat(thingList).hasSize(databaseSizeBeforeCreate + 1);
        Thing testThing = thingList.get(thingList.size() - 1);
        assertThat(testThing.getRoom()).isEqualTo(DEFAULT_ROOM);
        assertThat(testThing.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
    }

    @Test
    @Transactional
    public void createThingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = thingRepository.findAll().size();

        // Create the Thing with an existing ID
        thing.setId(1L);
        ThingDTO thingDTO = thingMapper.toDto(thing);

        // An entity with an existing ID cannot be created, so this API call must fail
        restThingMockMvc.perform(post("/api/things")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(thingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Thing in the database
        List<Thing> thingList = thingRepository.findAll();
        assertThat(thingList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllThings() throws Exception {
        // Initialize the database
        thingRepository.saveAndFlush(thing);

        // Get all the thingList
        restThingMockMvc.perform(get("/api/things?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(thing.getId().intValue())))
            .andExpect(jsonPath("$.[*].room").value(hasItem(DEFAULT_ROOM.intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())));
    }
    

    @Test
    @Transactional
    public void getThing() throws Exception {
        // Initialize the database
        thingRepository.saveAndFlush(thing);

        // Get the thing
        restThingMockMvc.perform(get("/api/things/{id}", thing.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(thing.getId().intValue()))
            .andExpect(jsonPath("$.room").value(DEFAULT_ROOM.intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingThing() throws Exception {
        // Get the thing
        restThingMockMvc.perform(get("/api/things/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateThing() throws Exception {
        // Initialize the database
        thingRepository.saveAndFlush(thing);

        int databaseSizeBeforeUpdate = thingRepository.findAll().size();

        // Update the thing
        Thing updatedThing = thingRepository.findById(thing.getId()).get();
        // Disconnect from session so that the updates on updatedThing are not directly saved in db
        em.detach(updatedThing);
        updatedThing
            .room(UPDATED_ROOM)
            .description(UPDATED_DESCRIPTION);
        ThingDTO thingDTO = thingMapper.toDto(updatedThing);

        restThingMockMvc.perform(put("/api/things")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(thingDTO)))
            .andExpect(status().isOk());

        // Validate the Thing in the database
        List<Thing> thingList = thingRepository.findAll();
        assertThat(thingList).hasSize(databaseSizeBeforeUpdate);
        Thing testThing = thingList.get(thingList.size() - 1);
        assertThat(testThing.getRoom()).isEqualTo(UPDATED_ROOM);
        assertThat(testThing.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    public void updateNonExistingThing() throws Exception {
        int databaseSizeBeforeUpdate = thingRepository.findAll().size();

        // Create the Thing
        ThingDTO thingDTO = thingMapper.toDto(thing);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restThingMockMvc.perform(put("/api/things")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(thingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Thing in the database
        List<Thing> thingList = thingRepository.findAll();
        assertThat(thingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteThing() throws Exception {
        // Initialize the database
        thingRepository.saveAndFlush(thing);

        int databaseSizeBeforeDelete = thingRepository.findAll().size();

        // Get the thing
        restThingMockMvc.perform(delete("/api/things/{id}", thing.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Thing> thingList = thingRepository.findAll();
        assertThat(thingList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Thing.class);
        Thing thing1 = new Thing();
        thing1.setId(1L);
        Thing thing2 = new Thing();
        thing2.setId(thing1.getId());
        assertThat(thing1).isEqualTo(thing2);
        thing2.setId(2L);
        assertThat(thing1).isNotEqualTo(thing2);
        thing1.setId(null);
        assertThat(thing1).isNotEqualTo(thing2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ThingDTO.class);
        ThingDTO thingDTO1 = new ThingDTO();
        thingDTO1.setId(1L);
        ThingDTO thingDTO2 = new ThingDTO();
        assertThat(thingDTO1).isNotEqualTo(thingDTO2);
        thingDTO2.setId(thingDTO1.getId());
        assertThat(thingDTO1).isEqualTo(thingDTO2);
        thingDTO2.setId(2L);
        assertThat(thingDTO1).isNotEqualTo(thingDTO2);
        thingDTO1.setId(null);
        assertThat(thingDTO1).isNotEqualTo(thingDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(thingMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(thingMapper.fromId(null)).isNull();
    }
}
