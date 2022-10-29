package models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ParkingSpot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spotNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "floor_id", nullable = false)
	private ParkingFloor floor;
	
	private Integer size;
	
	@Column(name = "for_disabled")
	private boolean forDisabled;
	
	@Column(name = "is_free")
	private boolean isFree;

	public Long getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(Long spotNumber) {
		this.spotNumber = spotNumber;
	}

	public ParkingFloor getFloor() {
		return floor;
	}

	public void setFloor(ParkingFloor floor) {
		this.floor = floor;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public boolean isForDisabled() {
		return forDisabled;
	}

	public void setForDisabled(boolean forDisabled) {
		this.forDisabled = forDisabled;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	
}
