package it.contrader.repository;

import it.contrader.domain.Apartment;
import it.contrader.domain.Room;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Room entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RoomRepository extends MyRepository<Room, Long> {
	
	//Custom QUERY, gets all apartments depending on tutor_id
	@Override
	@Query(value = "SELECT * FROM room e WHERE e.apartment = ?1", nativeQuery = true)
	List<Room> findAllBy(Long id);
}
