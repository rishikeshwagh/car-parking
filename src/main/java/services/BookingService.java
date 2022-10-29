package services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Ticket;
import models.VehicleType;
import repositories.ParkingFloorRepo;
import repositories.ParkingSpotRepo;
import repositories.TicketRepository;

public class BookingService {
	
	@Autowired
	private ParkingSpotRepo spotRepo;
	
	@Autowired
	private ParkingFloorRepo floorRepo;
	
	@Autowired
	private TicketRepository ticketRepo;
	
	public synchronized Ticket getSpot(long floor, VehicleType type, String vehicleNumber) {
		
		ParkingFloor parkingFloor = floorRepo.findById(floor).get();
		
		List<ParkingSpot> spots = spotRepo.findByFloorAndIsFree(parkingFloor, true);
		
		//use some algorithm to find closest spot
		ParkingSpot spot= spots.get(0);
		
		Ticket ticket = new Ticket();
		ticket.setEntryTime(new Date(System.currentTimeMillis()));
		ticket.setSpot(spot);
		ticket.setVehicleType(type);
		ticket.setVehicleNumber(vehicleNumber);
		
		spot.setFree(false);
		spotRepo.saveAndFlush(spot);
		
		ticketRepo.saveAndFlush(ticket);
		
		return ticket;
	}
	
	public void freeSpot(Ticket ticket) {
		
		ParkingSpot spot= ticket.getSpot();
		spot.setFree(true);
		spotRepo.saveAndFlush(spot);
		ticket.setExitTime(new Date(System.currentTimeMillis()));
		
		ticketRepo.saveAndFlush(ticket);
	}
}
