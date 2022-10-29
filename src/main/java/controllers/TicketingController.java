package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import factory.GateFactory;
import models.CardDetails;
import models.Gate;
import models.Ticket;
import models.VehicleType;
import repositories.ParkingSpotRepo;
import services.BookingService;
import services.PaymentService;

@Controller
public class TicketingController {
	
	@Autowired
	private BookingService bookingservice;
	
	@Autowired
	private GateFactory gateFactory;
	
	@Autowired
	private PaymentService paymentService;
	
	public void entry(String name, VehicleType type, String vehicleNumber) throws Exception {
		
		Gate gate = gateFactory.getGateWithName(name);
		
		if(gate == null) {
			throw new Exception("No such gate");
		}
		Ticket ticket = bookingservice.getSpot(gate.getFloorId(), type, vehicleNumber);
		
		//printTicket(ticket);
	}
	
	public Double exit(Ticket ticket) {
		
		bookingservice.freeSpot(ticket);
		
		Double charge = paymentService.getCharges(ticket);
		
		return charge;
	}
	
	public void makePayment(CardDetails card) {
		paymentService.makePayment(card);
	}

}
