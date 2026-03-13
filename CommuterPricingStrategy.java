package Parking_Permit;

import java.math.BigDecimal;


public class CommuterPricingStrategy implements PricingStrategy {
	
	@Override
	public BigDecimal computeMonthly(PermitSelection selection) {
		
		BigDecimal Base = new BigDecimal("35.00");
		
		return Base.multiply(new BigDecimal("0.85"));
	}

}
