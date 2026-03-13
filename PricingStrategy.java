package Parking_Permit;

import java.math.BigDecimal;


public interface PricingStrategy {

	
	BigDecimal computeMonthly(PermitSelection selection);
}
