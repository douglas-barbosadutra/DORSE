package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Client;
import it.contrader.model.Room;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface RoomRepository extends MyRepository<Room, Long> {
	
	@Override
	@Query("SELECT e FROM #{#entityName} e WHERE e.apartment = ?1")
	List<Room> findAllBy(Long id);
}
