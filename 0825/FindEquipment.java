package lesson3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class FindEquipment {
	static Random rand = new Random();
	public static void initializeInventory(Inventory inventory){
		for(int i=0; i<1000 ;i++){
			String  serialNumber = String.valueOf(rand.nextInt(100000));
			HashMap<String, Object> properties = new HashMap<String, Object>();
			
			properties.put("equipmentType", "phone");
			properties.put("color", "white");
			properties.put("brand", "apple");
			properties.put("model", "11");
			properties.put("price", "5999");
			
			Inventory.database.put(serialNumber, new Equipment( serialNumber, new EquipmentSpec (properties) ));
		}

		for(int i=0; i<1000 ;i++){
			String  serialNumber = String.valueOf(rand.nextInt(100000));
			HashMap<String, Object> properties = new HashMap<String, Object>();
			
			properties.put("equipmentType", "phone");
			properties.put("color", "white");
			properties.put("brand", "huawei");
			properties.put("model", "p40");
			properties.put("price", "4999");
			
			Inventory.database.put(serialNumber, new Equipment( serialNumber, new EquipmentSpec (properties) ));
		}

		for(int i=0; i<1000 ;i++){
			String  serialNumber = String.valueOf(rand.nextInt(100000));
			HashMap<String, Object> properties = new HashMap<String, Object>();

			properties.put("equipmentType", "phone");
			properties.put("color", "white");
			properties.put("brand", "xiaomi");
			properties.put("model", "mi10");
			properties.put("price", "3999");
			
			Inventory.database.put(serialNumber, new Equipment( serialNumber, new EquipmentSpec (properties) ));
		}
		
		for(int i=0; i<1000 ;i++){
			String  serialNumber = String.valueOf(rand.nextInt(100000));
			HashMap<String, Object> properties = new HashMap<String, Object>();

			properties.put("equipmentType", "laptop");
			properties.put("color", "white");
			properties.put("brand", "apple");
			properties.put("model", "macbook13");
			properties.put("price", "5999");
			
			Inventory.database.put(serialNumber, new Equipment( serialNumber, new EquipmentSpec (properties) ));
		}
		
		for(int i=0; i<1000 ;i++){
			String  serialNumber = String.valueOf(rand.nextInt(100000));
			HashMap<String, Object> properties = new HashMap<String, Object>();

			properties.put("equipmentType", "server");
			properties.put("color", "white");
			properties.put("brand", "hp");
			properties.put("model", "hpserver");
			properties.put("price", "7999");
			
			Inventory.database.put(serialNumber, new Equipment( serialNumber, new EquipmentSpec (properties) ));
		}
		
		for(int i=0; i<1000 ;i++){
			String  serialNumber = String.valueOf(rand.nextInt(100000));
			HashMap<String, Object> properties = new HashMap<String, Object>();

			properties.put("equipmentType", "pc");
			properties.put("color", "white");
			properties.put("brand", "lenove");
			properties.put("model", "y9000x");
			properties.put("price", "8799");
			
			Inventory.database.put(serialNumber, new Equipment( serialNumber, new EquipmentSpec (properties) ));
		}
		
		System.out.println("Inventory intialized");
		System.out.println("Inventory size " + inventory.database.size());
	}
	
	public static void main(String[] args) {
		 Inventory inventory = new Inventory();
		 initializeInventory(inventory);
		 
		 HashMap<String, Object> properties = new HashMap();
		 properties.put("equipmentType", "phone");
		 properties.put("price", "3000-5000");
		 
		 EquipmentSpec clientSpec = new EquipmentSpec(properties);
		 
		 List matchingEquipments = inventory.search(clientSpec);
		 if(!matchingEquipments.isEmpty()){
			 System.out.println("You might like these equipments:");
			 for(Iterator i = matchingEquipments.iterator(); i.hasNext();){
				 Equipment curEq = (Equipment)i.next();
				 EquipmentSpec spec = curEq.getEquipmentSpec();
				 System.out.println("We have a "+ spec.getProperties().get("equipmentType") + " with the following properties:");
				 for (Iterator j = spec.getProperties().keySet().iterator(); j.hasNext();){
					 String propertyName = (String)j.next();
					 if(propertyName.equals("equipmentType"))
						 continue;
					 System.out.println(" " + propertyName + ":" + spec.getProperties().get(propertyName));
					 
				 }
				 System.out.println("You can have this " + spec.getProperties().get("equipmentType") + "vfor $" + curEq.getEquipmentSpec().getProperties().get("price"));
				 

			 }
		 }
		 else{
			System.out.println("Sorry, we have nothing for you."); 
		 }
	 }
}
