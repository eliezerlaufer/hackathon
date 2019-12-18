package neogrid.distribution.enums;

public enum VehicleType {
	GENERAL("Geral"), 
	ELECTRONICS("Eletronicos"), 
	FOOD("Alimentos"), 
	REFRIGERATED("Refrigerados"), 
	TOUR("Passeio");
	
	private String vehicleType;
	
	private VehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public static VehicleType valueOfVehicleType(String vehicleType) {
		for (VehicleType vehitype : values()) {
            if (vehitype.vehicleType.equals(vehicleType)) {
                return vehitype;
            }
        }
        return null;
	}
	
	@Override
    public String toString() {
        return this.vehicleType;
    }
}
