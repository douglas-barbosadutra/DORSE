package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.Room;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface RoomRepository extends MyRepository<Room, Long> {
	
	//Custom QUERY, gets all rooms depending on apartment_id
	@Override
	@Query(value = "SELECT * FROM room e WHERE e.apartment_id = ?1", nativeQuery = true)
	Iterable<Room> findAllBy(Long id);
}
