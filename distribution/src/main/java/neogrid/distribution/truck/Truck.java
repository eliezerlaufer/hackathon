package neogrid.distribution.truck;

import neogrid.distribution.enums.VehicleType;

public class Truck {

	private String name;
	private VehicleType vehicleType;
	private Double weight;
	private String destination;
	private String pathFilename;
	
	public String getPathFilename() {
		return pathFilename;
	}
	public void setPathFilename(String pathFilename) {
		this.pathFilename = pathFilename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
