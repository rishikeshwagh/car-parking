package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketNumber;
	
	private String vehicleNumber;
	
	@OneToOne(targetEntity = ParkingSpot.class, cascade = CascadeType.ALL)
	private ParkingSpot spot;
	
	private Date entryTime;
	private Date exitTime;
	private VehicleType vehicleType;
	
	public Long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public ParkingSpot getSpot() {
		return spot;
	}
	public void setSpot(ParkingSpot spot) {
		this.spot = spot;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Date getExitTime() {
		return exitTime;
	}
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}
	
	
	
}
