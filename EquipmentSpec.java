package lesson3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EquipmentSpec {
	private HashMap<String, Object> properties ;

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(HashMap<String, Object> properties) {
		this.properties = properties;
	}

	/**
	 * @return the properties
	 */
	public HashMap<String, Object> getProperties() {
		return properties;
	}
	
	
	public boolean matches(EquipmentSpec eqSpec) {
		for (Iterator i = eqSpec.getProperties().keySet().iterator();i.hasNext();){
			String propertyName = (String)i.next();
			if (propertyName.equals("price")){
				String priceString = eqSpec.getProperties().get(propertyName).toString();
				if(priceString.contains("-")){
					String lowPrice = priceString.split("-")[0];
					String highPrice = priceString.split("-")[1];
					int lp = Integer.parseInt(lowPrice);
					int hp = Integer.parseInt(highPrice);
//					System.out.println("lp:" + lp);
//					System.out.println("hp:" + hp);
					if (Integer.parseInt((String)properties.get(propertyName))<lp || Integer.parseInt((String)properties.get(propertyName))> hp){
//						if (Integer.parseInt((String)properties.get(propertyName)) == 3999){
//							System.out.println("3999");
//						}
//						System.out.println("Integer.parseInt((String)properties.get(propertyName)) " + Integer.parseInt((String)properties.get(propertyName)));
						return false;
					}else{
						continue;
					}
				}
			}
			if (!properties.get(propertyName).equals(eqSpec.getProperties().get(propertyName))){
				return false;
			}
		}
		return true;
	}
	
	public EquipmentSpec (HashMap<String, Object> properties){
		this.properties = properties;
	}

}
