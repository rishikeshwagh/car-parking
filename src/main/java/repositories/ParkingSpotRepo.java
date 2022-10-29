package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.ParkingFloor;
import models.ParkingSpot;

public interface ParkingSpotRepo extends JpaRepository<ParkingSpot, Long>{

	public List<ParkingSpot> findByFloorAndIsFree(ParkingFloor floor,boolean isFree);
}
