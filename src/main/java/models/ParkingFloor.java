package models;

import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ParkingFloor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long floor_id;
	
	@Column(name = "floor_name")
	private String floorName;
	private Integer level;
	
	@OneToMany(mappedBy = "floor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ParkingSpot> spots;

}
