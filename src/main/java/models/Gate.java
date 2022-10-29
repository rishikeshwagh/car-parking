package models;

import javax.persistence.*;

@Entity
public class Gate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private GateType type;
	
	@Column( name = "floor_id")
	private Long floorId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GateType getType() {
		return type;
	}
	public void setType(GateType type) {
		this.type = type;
	}
	public Long getFloorId() {
		return floorId;
	}
	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}
	

}
