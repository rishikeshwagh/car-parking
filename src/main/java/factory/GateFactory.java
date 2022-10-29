package factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import models.Gate;
import repositories.GateRepo;

public class GateFactory {
	
	private static Map<String,Gate> factory = new HashMap<String,Gate>(); 
	
	@Autowired
	private GateRepo gateRepo;
	
	public Gate getGateWithName(String name) {
		
		if(factory.containsKey(name)) {
			return factory.get(name);
		}else {
			List<Gate> gates=gateRepo.findByName(name);
			
			if(gates != null  && gates.size() > 0) {
				factory.put(name, gates.get(0));
			}
			
			return gates.get(0);
		}
	}
}
