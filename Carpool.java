package Parking_Permit;

import java.math.BigDecimal;

public class Carpool implements RateModifier {

	@Override
	public BigDecimal apply(BigDecimal price) {
		
		return price.multiply(new BigDecimal(".90"));
		
		
	}
}
