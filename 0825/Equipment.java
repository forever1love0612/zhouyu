package lesson3;


public class Equipment {
 
	private String serialNumber;
	private EquipmentSpec equipmentSpec;

	public Equipment(String serialNumber, EquipmentSpec equipmentSpec){
		this.setSerialNumber(serialNumber);
		this.setEquipmentSpec(equipmentSpec);
		
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param equipmentSpec the equipmentSpec to set
	 */
	public void setEquipmentSpec(EquipmentSpec equipmentSpec) {
		this.equipmentSpec = equipmentSpec;
	}

	/**
	 * @return the equipmentSpec
	 */
	public EquipmentSpec getEquipmentSpec() {
		return equipmentSpec;
	}
	
}
