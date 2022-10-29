package models;

import java.util.List;

public class ParkingLot {
	
	private String id;
	private String address;	
	
	private List<ParkingFloor> floors; 
	private List<Gate> entry;
	private List<Gate> exit;

}
