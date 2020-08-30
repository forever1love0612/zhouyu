package lesson3;
import java.util.ArrayList;
import java.util.HashMap;

import lesson3.EquipmentSpec;
import lesson3.Equipment;

public class Inventory {
	public static HashMap<String, Equipment> database=new HashMap<String, Equipment>();
	
	public void addEquipment(String serialNumber, EquipmentSpec eqSpec) {
		if (!(database.containsKey(serialNumber))){
			database.put(serialNumber, new Equipment(serialNumber, eqSpec));
		}
			
	}
	public Equipment get(String serialNumber) {
		return database.get(serialNumber) ;
	}
	public ArrayList<Equipment> search(EquipmentSpec eqSpec) {
		ArrayList<Equipment> results = new ArrayList<Equipment>(); 
		for(String key:database.keySet()){
			if(database.get(key).getEquipmentSpec().matches(eqSpec)){
				results.add(database.get(key));
			}
		}
		return results;
	}
		
	}

