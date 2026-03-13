package Parking_Permit;

public final class PermitSelection implements Validatable {
	
	private PermitType permitType;
	private VehicleType vehicleType;
	private boolean carpool;
	private int months;
	
	public PermitSelection(PermitType permitType, VehicleType vehicleType, boolean carpool, int months) {
		
		this.permitType = permitType;
		this.vehicleType = vehicleType;
		this.carpool = carpool;
		this.months = months;
	}
	public PermitType getPermitType() {
		return permitType;
	}
	public VehicleType getVehcileType() {
		return vehicleType;
	}
	public boolean isCarpool() {
		return carpool;
	}
	public int getMonths() {
		return months;
	}
	
	@Override
	public void validate() {
		if (months <1 || months > 12) {
			throw new InvalidSelectionException("Months have to be in between 1 to 12,");
		}
	}
}
