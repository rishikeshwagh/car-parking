package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Gate;

public interface GateRepo extends JpaRepository<Gate, Long>{
	
	public List<Gate> findByName(String name);

}
