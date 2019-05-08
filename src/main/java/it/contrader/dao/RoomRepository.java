package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Room;

@Repository
@Transactional
public interface RoomRepository extends CrudRepository<Room, Long> {

}
