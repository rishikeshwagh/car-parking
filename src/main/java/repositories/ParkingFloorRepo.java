package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import models.ParkingFloor;

public interface ParkingFloorRepo  extends JpaRepository<ParkingFloor, Long>{

	public List<ParkingFloor> findByName(String name);
}
